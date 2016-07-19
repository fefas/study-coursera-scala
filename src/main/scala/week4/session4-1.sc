import week4._

val zero = Zero
val one = new Succ(Zero)
val two = new Succ(one)
val three = new Succ(two)
val five = two + three
val four = five - one
