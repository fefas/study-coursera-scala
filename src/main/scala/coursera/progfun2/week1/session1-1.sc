case class Book(title: String, authors: List[String])

val booksList: List[Book] = List(
  Book(
    "Structure and Interpretation of Computer Programs",
    List("Abelson, Harald", "Sussman", "Gerald J.")
  ),
  Book(
    "Introduction to Functional Programming",
    List("Bird, Richard", "Wadler, Phil")
  ),
  Book(
    "Effective Java",
    List("Bloch, Joshua")
  ),
  Book(
    "Effective Java 2",
    List("Bloch, Joshua")
  ),
  Book(
    "Java Puzzlers",
    List("Bloch, Joshua", "Gafter, Neal")
  ),
  Book(
    "Programming in Scala",
    List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")
  )
)

for (b <- booksList; a <- b.authors; if a startsWith "Bird,") yield b

for (b <- booksList; if (b.title indexOf "Program") >= 0) yield b.title

{
  for {
    b1 <- booksList
    b2 <- booksList
    if b1 != b2
    a1 <- b1.authors
    a2 <- b2.authors
    if a1 == a2
  } yield a1
}.distinct

val booksSet: Set[Book] = Set(
  Book(
    "Structure and Interpretation of Computer Programs",
    List("Abelson, Harald", "Sussman", "Gerald J.")
  ),
  Book(
    "Introduction to Functional Programming",
    List("Bird, Richard", "Wadler, Phil")
  ),
  Book(
    "Effective Java",
    List("Bloch, Joshua")
  ),
  Book(
    "Effective Java 2",
    List("Bloch, Joshua")
  ),
  Book(
    "Java Puzzlers",
    List("Bloch, Joshua", "Gafter, Neal")
  ),
  Book(
    "Programming in Scala",
    List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")
  )
)

for {
  b1 <- booksSet
  b2 <- booksSet
  if b1 != b2
  a1 <- b1.authors
  a2 <- b2.authors
  if a1 == a2
} yield a1
