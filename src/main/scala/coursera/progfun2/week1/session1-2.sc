case class Book(title: String, authors: List[String])

val books: List[Book] = List(
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

// Translate for expression into high-order functions

for (b <- books; a <- b.authors; if a startsWith "Bird") yield b.title

books flatMap(
  b => for (a <- b.authors; if a startsWith "Bird") yield b.title
)

books flatMap(
  b => for (a <- b.authors withFilter (a => a startsWith "Bird")) yield b.title
)

books flatMap(b =>
  b.authors withFilter (a => a startsWith "Bird") map (_ => b.title)
)
