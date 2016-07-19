
// 1.4 - abs
def abs(x: Double) = if (x < 0) -x else x

// 1.5, 1.6 - sqare root with Newton's method
def sqrt(x: Double) = {
  def sqrtIter(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))

  def isGoodEnough(guess: Double) = abs(guess * guess - x) / x < 0.001

  def improve(guess: Double) = (guess + x / guess) / 2

  sqrtIter(1.0)
}

sqrt(2)
sqrt(4)
sqrt(16)
sqrt(25)
sqrt(1e-6)
sqrt(1e60)

// 1.7 - gcf
def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

gcd(14, 21)

// 1.7 - factorial
def factorialNotTail(n: Int): Int = if (n == 0) 1 else n * factorialNotTail(n - 1)

factorialNotTail(0)
factorialNotTail(1)
factorialNotTail(2)
factorialNotTail(7)

def factorial(n: Int): Int =  {
  def loop(n: Int, acc: Int): Int =
    if (n == 0) acc
    else loop(n - 1, n * acc)

  loop(n, 1)
}

factorial(0)
factorial(1)
factorial(2)
factorial(7)
