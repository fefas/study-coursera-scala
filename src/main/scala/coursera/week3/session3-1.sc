import week3._

val t1 = new NonEmpty(10, Empty, Empty)
val t2 = t1 incl 4
val t3 = t2 incl 16
val t4 = t3 incl 2
val t5 = t4 incl 6

val t6 = new NonEmpty(7, Empty, Empty)
val t7 = t5 union t3


val ta = new NonEmpty(7, Empty, Empty)
val tb = new NonEmpty(6, Empty, Empty)
val tc = ta union tb
val td = new NonEmpty(4, Empty, Empty)
val te = tc union td
