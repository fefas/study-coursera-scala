import week4._

def eval(e: Expr): Int = e match {
  case Number(n) => n
  case Sum(e1, e2) => eval(e1) + eval(e2)
}

def show(e: Expr): String = e match {
  case Number(n) => n.toString()
  case Sum(e1, e2) => "(" + show(e1) + " + " + show(e2) + ")"
}

val expr1 = Sum(Number(3), Number(5))
val expr2 = Sum(Number(2), expr1)
val expr3 = Sum(expr2, expr1)

eval(expr1)
eval(expr2)
eval(expr3)

show(expr1)
show(expr2)
show(expr3)
