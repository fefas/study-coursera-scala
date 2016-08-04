package week4

object Zero extends Nat {
  def isZero = true
  def predecessor = throw new Error("Zero.predecessor")
  def +(that: Nat) = that
  def -(that: Nat) = if (that isZero) this else throw new Error("Zero.-")

  override def toString() = "0"
}
