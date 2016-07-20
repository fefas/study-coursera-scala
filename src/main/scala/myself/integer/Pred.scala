package myself.integer

case class Pred(n: Int) extends Int {
  def +(that: Int): Int = that match {
    case Zero => this
    case Succ(m) => this.successor + m
    case Pred(m) => this.predecessor + m
  }
  def -(that: Int): Int = that match {
    case Zero => this
    case Succ(m) => this.predecessor - m
    case Pred(m) => this.successor - m
  }

  override def toString() = "." + n
}
