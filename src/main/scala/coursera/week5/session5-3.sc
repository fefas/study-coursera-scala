import math._

def msort[T](list: List[T])(lessThan: (T, T) => Boolean): List[T] = {
  val n = list.length / 2
  if (n == 0) list
  else {
    def merge(left: List[T], right: List[T]): List[T] = (left, right) match {
      case (Nil, right) => right
      case (left, Nil) => left
      case (leftElem :: leftTail, rightElem :: rightTail) => {
        if (lessThan(leftElem, rightElem)) leftElem :: merge(leftTail, right)
        else rightElem :: merge(left, rightTail)
      }
    }

    val (fst, snd) = list splitAt n
    merge(msort(fst)(lessThan), msort(snd)(lessThan))
  }
}

val nums = List(5, 10, 8, 4, -5, -3, -8, 2, 1, 0, -5, 7, 2, 5)

msort(nums)((a: Int, b: Int) => a < b)
msort(nums)((a: Int, b: Int) => a > b)

msort(nums)((a: Int, b: Int) => abs(a) < abs(b))
msort(nums)((a: Int, b: Int) => if (abs(a) == abs(b)) a < b else abs(a) < abs(b))

msort(nums)((a: Int, b: Int) => if (a % 2 == b % 2) a < b else if (a % 2 == 0) false else true)
