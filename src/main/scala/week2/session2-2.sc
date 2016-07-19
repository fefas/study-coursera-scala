def factorial(n: Int) = {
  def loop(n: Int, acc: Int): Int =
    if (n == 0) acc
    else loop(n - 1, n * acc)

  loop(n, 1)
}

def sum(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumF(a + 1, b)
  sumF
}

def sumInts = sum(x => x)
def sumCubes = sum(x => x * x * x)
def sumFactorial = sum(factorial)

sumInts(1, 4)
sumCubes(3, 4)
sumFactorial(2, 4)

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
}

def product(f: Int => Int)(a: Int, b: Int): Int = {
  mapReduce(f, (x, y) => x * y, 1)(a, b)
}

product(x => x)(1, 3)

def fact(n: Int): Int = product(x => x)(1, n)

fact(7)