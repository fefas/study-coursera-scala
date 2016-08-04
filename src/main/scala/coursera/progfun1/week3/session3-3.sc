import week3._

def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

singleton[Int](1)
singleton[Boolean](true)

def nth[T](n: Int, list: List[T]): T = {
  if (list.isEmpty) throw new IndexOutOfBoundsException()
  else if (n > 0) nth(n - 1, list.tail)
  else list.head
}

val list = new Cons[Int](3, new Cons[Int](2, singleton[Int](1)))

nth[Int](2, list)
