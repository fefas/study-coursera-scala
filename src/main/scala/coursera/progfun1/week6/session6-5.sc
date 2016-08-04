val mnemonics = Map(
  '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO",
  '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ"
)

//def translate()

val charCode: Map[Char, Char] =
  for ((digit, str) <- mnemonics; ltr <- str) yield ltr -> digit

def wordCode(word: String): String =
  word.toUpperCase map charCode

wordCode("Java")

val wordsForNum: Map[String, Seq[String]] =
  words groupBy wordCode