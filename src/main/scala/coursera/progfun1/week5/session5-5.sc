val data = List(3, 2, 1, 4)

def sum1(list: List[Int]) = (0 :: list) reduceLeft ((a, b) => a + b)
def product1(list: List[Int]) = (1 :: list) reduceLeft ((a, b) => a * b)

sum1(data)
product1(data)

def sum2(list: List[Int]) = (0 :: list) reduceLeft (_ + _)
def product2(list: List[Int]) = (1 :: list) reduceLeft (_ * _)

sum2(data)
product2(data)

def sum3(list: List[Int]) = (list foldLeft 0) (_ + _)
def product3(list: List[Int]) = (list foldLeft 1) (_ * _)

sum3(data)
product3(data)

def mapFun[T, U](list: List[T], f: T => U): List[U] =
  (list foldRight List[U]())((elem: T, result: List[U]) => f(elem) :: result)

def lengthFun[T](list: List[T]): Int =
  (list foldRight 0)((elem: T, n: Int) => n + 1)

mapFun(data, (x: Int) => x * x)
lengthFun(data)
