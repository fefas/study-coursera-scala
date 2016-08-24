package coursera.progfun2.week3

abstract class Simulation {
  type Action = () => Unit

  case class Event(time: Int, action: Action)

  private var curtime: Int = 0
  def currentTime: Int = curtime

  private var agenda: Agenda = List()

  private def insert (ag: List[Event], item: Event): List[Event] = ag match {
    case first :: rest if first.time <= item.time => first :: insert(rest, item)
    case _ => item :: ag
  }

  def afterDelay(delay: Int)(block: => Unit): Unit = {
    val item = Event(curtime + delay, () => block)
    agenda = insert(agenda, item)
  }

  def run(): Unit = {
    afterDelay(0) {
      println("*** simulation started, time = " + currentTime + " ***")
    }
    loop()
  }

  private def loop(): Unit = agenda match {
    case first :: rest =>
      agenda = rest
      curtime = first.time
      first.action()
      loop()
    case Nil =>
  }

  private type Agenda = List[Event]
}
