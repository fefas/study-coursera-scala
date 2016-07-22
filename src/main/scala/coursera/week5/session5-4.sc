val nums = List(-4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

def squareList(list: List[Int]): List[Int] = list match {
  case Nil => List()
  case head :: tail => head * head :: squareList(tail)
}

def squareList2(list: List[Int]): List[Int] = list map (x => x * x)

squareList(nums)
squareList2(nums)

def posElem(list: List[Int]): List[Int] = list match {
  case Nil => List()
  case head :: tail => if (head > 0) head :: posElem(tail) else posElem(tail)
}

def posElem2(list: List[Int]): List[Int] = list filter (x => x > 0)

posElem(nums)
posElem2(nums)

nums filter (x => x > 0)
nums filterNot (x => x > 0)
nums partition (x => x > 0)

nums takeWhile (x => x > 0)
nums takeWhile (x => x < 0)

nums dropWhile (x => x > 0)
nums dropWhile (x => x < 0)

List(2, -4, 5, 7, 1) span (x => x > 0)
List(2, -4, 5, 7, 1) span (x => x < 0)


def pack[T](list: List[T]): List[List[T]] = list match {
  case Nil => Nil
  case head :: tail => {
    val (first, rest) = list span (x => x == head)
    first :: pack(rest)
  }
}

def encode[T](list: List[T]): List[(T, Int)] =
  pack(list) map (sublist => (sublist.head, sublist.length))

val data = List("a", "a", "a", "b", "c", "c", "a")

pack(data)
encode(data)
