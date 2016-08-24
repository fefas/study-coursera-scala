def powerWithWhile(x: Double, exp: Int): Double = {
  var r = 1.0
  var i = exp
  while (i > 0) {
    r = r * x
    i = i - 1
  }
  r
}
powerWithWhile(2, 4)

def powerWithFor(x: Double, exp: Int): Double = {
  var r = 1.0
  for (i <- 1 until exp) {
    r = r * x
  }
  r
}
powerWithFor(2, 3)

for (i <- 1 until 3; j <- "abc") println(i + " " + j)