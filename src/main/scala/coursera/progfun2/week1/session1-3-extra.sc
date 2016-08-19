trait Generator[+T] {
  self =>

  def generate: T

  def map[S](f: T => S): Generator[S] = new Generator[S] {
    def generate = f(self.generate)
  }

  def flatMap[S](f: T => Generator[S]): Generator[S] = f(self.generate)
}

val integers = new Generator[Int] {
  val rand = new java.util.Random
  def generate = rand.nextInt()
}

def pairs[T, U](t: Generator[T], u: Generator[U]) =
  for (x <- t; y <- u) yield (x, y)

def triples[T, U, V](t: Generator[T], u: Generator[U], v: Generator[V]) =
  for (x <- t; y <- u; z <- v) yield (x, y, z)

// t.flatMap(x => for (y <- u) yield (x, y))
// t.flatMap(x => u map (y => (x, y)))
// t.flatMap(x => new Generator { def generate = (x, u.generate) }
// new Generator { def generate = (t.generate, u.generate) }

println(integers.generate)
println(integers.generate)

val integerPairs = pairs(integers, integers)

println(integerPairs.generate)
println(integerPairs.generate)
println(integerPairs.generate)

val integerPairs2 = pairs(integers, integers)

println(integerPairs2.generate)
println(integerPairs2.generate)

val integerPairs3 = new Generator[(Int, Int)] {
  def generate = (integers.generate, integers.generate)
}

println(integerPairs3.generate)
println(integerPairs3.generate)
println(integerPairs3.generate)
println(integerPairs3.generate)

val integerPairs4 = integers.flatMap(x => new Generator[(Int, Int)] {
  def generate = (x, integers.generate)
})

println(integerPairs4.generate)
println(integerPairs4.generate)
println(integerPairs4.generate)
println(integerPairs4.generate)

val integerPairs5 = {
  val x = integers.generate
  new Generator[(Int, Int)] {
    def generate = (x, integers.generate)
  }
}

println(integerPairs5.generate)
println(integerPairs5.generate)
println(integerPairs5.generate)
println(integerPairs5.generate)

val integerTriples = triples(integers, integers, integers)

println(integerTriples.generate)
println(integerTriples.generate)
println(integerTriples.generate)


