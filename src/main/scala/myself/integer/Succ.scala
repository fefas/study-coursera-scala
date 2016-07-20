package myself.integer

case class Succ(n: Int) extends Int {
  def +(that: Int): Int = n + that.successor
  def -(that: Int): Int = that match {
    case Zero => this
    case Succ(m) => this.predecessor - m
    case Pred(m) => this.successor - m
  }

  override def toString() = n + "."
}
