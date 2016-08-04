val fruits = Set("apple", "banana", "pear")
val nums = (1 to 6).toSet

nums map (_ + 2)
fruits filter (_.startsWith("app"))

nums map (_ / 2)
nums contains 5

def isSafe(col: Int, queens: List[Int]): Boolean = {
  val currentRow = queens.length
  val queensWithRows = (currentRow - 1 to 0 by -1) zip queens
  queensWithRows forall {
    case (r, c) => col != c && math.abs(col - c) != currentRow - r
  }
}

def queens(n: Int): Set[List[Int]] = {
  def placeQueens(k: Int): Set[List[Int]] =
    if (k == 0) Set(List())
    else for {
        queens <- placeQueens(k - 1)
        col <- 0 until n
        if isSafe(col, queens)
      } yield col :: queens

  placeQueens(n)
}

def show(queens: List[Int]) = {
  val lines =
    for (col <- queens.reverse)
    yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
  "\n" + (lines mkString "\n")
}

queens(8)
(queens(8) map show) mkString "\n"
