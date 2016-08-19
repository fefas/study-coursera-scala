trait Generator[+T] {
  def generate: T
}

val integers = new Generator[Int] {
  val rand = new java.util.Random
  def generate = rand.nextInt()
}

val booleans = new Generator[Boolean] {
  def generate = integers.generate >= 0
}

val pairs = new Generator[(Int, Int)] {
  def generate = (integers.generate, integers.generate)
}

trait GeneratorFor[+T] {
  self =>

  def generate: T

  def map[S](f: T => S): GeneratorFor[S] = new GeneratorFor[S] {
    def generate: S = f(self.generate)
  }

  def flatMap[S](f: T => GeneratorFor[S]): GeneratorFor[S] = new GeneratorFor[S] {
    def generate: S = f(self.generate).generate
  }
}

val integersFor = new GeneratorFor[Int] {
  val rand = new java.util.Random
  def generate = rand.nextInt()
}

val booleansFor = for (x <- integersFor) yield x >= 0

def pairsFor = for {
  x <- integersFor
  y <- integersFor
} yield (x, y)

//
// Generator examples

def single[T](x: T): GeneratorFor[T] = new GeneratorFor[T] {
  def generate = x
}
val singleGer = single(1)
singleGer.generate
singleGer.generate

def choose(lo: Int, hi: Int): GeneratorFor[Int] =
  for (x <- integersFor) yield lo + Math.abs(x) % (hi - lo)
val choose6To10 = choose(6, 10)
choose6To10.generate
choose6To10.generate
choose6To10.generate
choose6To10.generate

def oneOf[T](xs: T*): GeneratorFor[T] =
  for (idx <- choose(0, xs.length)) yield xs(idx)
val oneOfColors = oneOf("red", "blue", "yellow")
oneOfColors.generate
oneOfColors.generate
oneOfColors.generate
oneOfColors.generate

def emptyLists = single(Nil)
def nonEmptyLists = for {
  head <- integersFor
  tail <- lists
} yield head :: tail
def lists: GeneratorFor[List[Int]] = for {
  isEmpty <- booleansFor
  list <- if (isEmpty) emptyLists else nonEmptyLists
} yield list
lists.generate
lists.generate
lists.generate
lists.generate
lists.generate

trait Tree {
  override def toString = this match {
    case Leaf(x) => "" + x
    case Inner(l, r) => "{" + l.toString + "." + r.toString + "}"
  }
}
case class Inner(left: Tree, right: Tree) extends Tree
case class Leaf(x: Int) extends Tree

def leafs: GeneratorFor[Leaf] = for {
  x <- choose(5, 15)
} yield Leaf(x)
def inners: GeneratorFor[Inner] = for {
  l <- trees
  r <- trees
} yield Inner(l, r)
def trees: GeneratorFor[Tree] = for {
  isLeaf <- booleansFor
  tree <- if (isLeaf) leafs else inners
} yield tree
trees.generate
trees.generate
trees.generate
trees.generate
