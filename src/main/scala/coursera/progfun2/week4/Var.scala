package coursera.progfun2.week4

class Var[T](expr: => T) extends Signal[T](expr) {
  def update(expr: => T): Unit = ???
}
