package week4

class Succ(n: Nat) extends Nat {
  def isZero = false
  def predecessor = n
  def +(that: Nat) = new Succ(n + that)
  // my solution:
  // def +(that: Nat) = if (that isZero) this else new Succ(this) + that.predecessor
  def -(that: Nat) = if (that isZero) this else n - that.predecessor

  override def toString() = n + "."
}
