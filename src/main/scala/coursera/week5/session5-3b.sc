import math._

def msort[T](list: List[T])(implicit ord: Ordering[T]): List[T] = {
  val n = list.length / 2
  if (n == 0) list
  else {
    def merge(left: List[T], right: List[T]): List[T] = (left, right) match {
      case (Nil, right) => right
      case (left, Nil) => left
      case (leftElem :: leftTail, rightElem :: rightTail) => {
        if (ord.lt(leftElem, rightElem)) leftElem :: merge(leftTail, right)
        else rightElem :: merge(left, rightTail)
      }
    }

    val (fst, snd) = list splitAt n
    merge(msort(fst), msort(snd))
  }
}

val nums = List(5, 10, 8, 4, -5, -3, -8, 2, 1, 0, -5, 7, 2, 5)
val fruits = List("apple", "pineapple", "orange", "banana")

msort(nums)
msort(fruits)
