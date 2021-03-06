package coursera.progfun2.week4

trait Publisher {
  private var subscribers: Set[Subscriber] = Set()

  def subscribe(subscriber: Subscriber): Unit =
    subscribers += subscriber

  def publish(): Unit =
    subscribers.foreach(_.handler(this))
}
