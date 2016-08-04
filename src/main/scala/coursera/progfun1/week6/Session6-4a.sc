var romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
var capitalOfCountry = Map("Brazil" -> "Brasilia", "Switzerland" -> "Bern")

capitalOfCountry("Brazil")
capitalOfCountry get "Germany"
capitalOfCountry get "Brazil"

def showCapital(country: String) = capitalOfCountry get country match {
  case Some(capital) => capital
  case None => "missing data"
}

showCapital("Germany")
showCapital("Brazil")

val fruit = List("apple", "pear", "orange", "pineapple")

fruit sortWith (_.length < _.length)
fruit.sorted

fruit groupBy (_.head)



class Poly(val terms: Map[Int, Double]) {
  def +(other: Poly): Poly = new Poly(terms ++ (other.terms map adjust))
  def adjust(term: (Int, Double)): (Int, Double) = {
    val (exp, coeff) = term
    terms get exp match {
      case Some(coeff1) => exp -> (coeff + coeff1)
      case None => exp -> coeff
    }
  }
  override def toString(): String =
    (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
}

val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))

p1 + p2

val cap1 = capitalOfCountry withDefaultValue "<unknown>"
cap1("Germany")
