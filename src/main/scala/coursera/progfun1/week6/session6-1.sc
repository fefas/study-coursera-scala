val nums = Vector(1, 2, 3, -88)
val people = Vector("Bob", "James", "Peter")

8 +: nums
nums :+ 7

val arr = Array(1, 2, 3, 44)
arr map (x => x * 2)

val str = "Hello World"
str filter (c => c.isUpper)

val r: Range = 1 until 5
val s: Range = 1 to 15 by 3
val t: Range = 6 to 1 by -2

str exists (c => c.isUpper)
str forall (c => c.isUpper)

val pairs = List(1, 2, 4) zip str
pairs.unzip

str.flatMap (c => List('.', c))

nums.sum
nums.max

(1 to 3) flatMap (x => (4 to 5) map (y => (x, y)))

def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)

isPrime(10)
isPrime(7)
