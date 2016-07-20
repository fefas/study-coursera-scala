val pair = ("answer", 42)
val (label, value) = pair

def msort(list: List[Int]): List[Int] = {
  val n = list.length / 2
  if (n == 0) list
  else {
    def merge(left: List[Int], right: List[Int]): List[Int] = (left, right) match {
      case (Nil, right) => right
      case (left, Nil) => left
      case (leftElem :: leftTail, rightElem :: rightTail) => {
        if (leftElem < rightElem) leftElem :: merge(leftTail, right)
        else rightElem :: merge(left, rightTail)
      }
    }

    val (fst, snd) = list splitAt n
    merge(msort(fst), msort(snd))
  }
}

val list = List(4, 5, 6, 1, 2, 19, 2, 5)
msort(list)