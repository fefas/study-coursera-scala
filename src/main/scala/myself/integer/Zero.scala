package myself.integer

object Zero extends Int {
  def +(that: Int): Int = that
  def -(that: Int): Int = that match {
    case Zero => this
    case Succ(m) => this.predecessor - m
    case Pred(m) => this.successor - m
  }
  def <(that: Int): Boolean = that match {
    case Succ(_) => true
    case _ => false
  }

  override def toString: String = "0"
}
