package myself.integer

object Zero extends Int {
  def +(that: Int): Int = that
  def -(that: Int): Int = that match {
    case Zero => this
    case Succ(n) => this.predecessor - n
    case Pred(n) => this.successor - n
  }

  override def toString: String = "0"
}
