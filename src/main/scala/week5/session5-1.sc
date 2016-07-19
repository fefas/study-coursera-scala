val xs = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
val ys = List(21, 22, 23, 24, 25)

xs.length

xs.head
xs.tail
xs.last
xs.init

xs take 4
xs drop 4
xs(2)

xs ++ ys
xs.reverse
xs.updated(4, 1000)

xs indexOf 3
xs indexOf 10
xs contains 2
xs contains 22

def last[T](list: List[T]): T = list match {
  case List() => throw new Error("last of empty list")
  case List(elem) => elem
  case head :: tail => last(tail)
}

def init[T](list: List[T]): List[T] = list match {
  case List() => throw new Error("init of empty list")
  case List(elem) => List()
  case head :: tail => head :: init(tail)
}

def concat[T](aList: List[T], bList: List[T]): List[T] = aList match {
  case List() => bList
  case head :: tail => head :: concat(tail, bList)
}

def reverse[T](list: List[T]): List[T] = list match {
  case List() => List()
  case head :: tail => concat(reverse(tail), List(head))
}

last(xs)
init(xs)
concat(xs, ys)
reverse(xs)

def removeAt[T](n: Int, list: List[T]): List[T] = (list take n) ::: (list drop n + 1)

removeAt(1, xs)
removeAt(20, xs)

def flatten(list: List[Any]): List[Any] = list match {
  case List() => List()
  case (elem: List[Any]) :: tail => flatten(elem) ::: flatten(tail)
  case elem :: tail => elem :: flatten(tail)
}

flatten(List(List(1, 1), 2, List(3, List(5, 8))))
