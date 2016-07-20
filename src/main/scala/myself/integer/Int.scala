package myself.integer

abstract class Int {
  def predecessor: Int = this match {
    case Succ(n) => n
    case _ => Pred(this)
  }
  def successor: Int = this match {
    case Pred(n) => n
    case _ => Succ(this)
  }
  def +(that: Int): Int
  def -(that: Int): Int
  def <(that: Int): Boolean
  def <=(that: Int): Boolean = if (this == that) true else this < that
  def >(that: Int): Boolean = !(this <= that)
  def >=(that: Int): Boolean = !(this < that)
}
