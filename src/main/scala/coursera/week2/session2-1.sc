def factorial(n: Int) = {
  def loop(n: Int, acc: Int): Int =
    if (n == 0) acc
    else loop(n - 1, n * acc)

  loop(n, 1)
}

// 2.1 - math sum tail recursive
def sum(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int =
    if (a > b) acc else loop(a + 1, f(a) + acc)

  loop(a, 0)
}

sum(x => x)(1, 4)
sum(x => x * x)(1, 4)
sum(x => x * x * x)(1, 4)
sum(factorial)(1, 4)
