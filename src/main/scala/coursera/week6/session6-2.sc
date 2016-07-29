def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)

// return a collection of pairs (i, j) where 1 <= j < i < n and i + j is prime
(1 until 7) flatMap (i => (1 until i) map (j => (i, j))) filter (pair => isPrime(pair._1 + pair._2))


for {
  i <- 1 until 7
  j <- 1 until i
  if isPrime(i + j)
} yield (i, j)

def scalarProduct(aList: List[Double], bList: List[Double]): Double =
  (for ((a, b) <- aList zip bList) yield a * b).sum

scalarProduct(List(1, 2, 3), List(4, 5, 6))