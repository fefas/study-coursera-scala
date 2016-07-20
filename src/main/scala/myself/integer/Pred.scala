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
  def <(that: Int): Boolean = that match {
    case Pred(m) => this.successor < m
    case _ => true
  }

  override def toString() = "." + n
}
