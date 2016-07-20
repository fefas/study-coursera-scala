package myself.integer

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class IntegerSuite extends FunSuite {

  trait SomeNumbers {
    val zero = Zero

    val one = zero.successor
    val two = one.successor
    val three = two.successor
    val four = three.successor
    val five = four.successor
    val six = five.successor
    val seven = six.successor
    val eight = seven.successor
    val nine = eight.successor
    val ten = nine.successor

    val minusOne = zero.predecessor
    val minusTwo = minusOne.predecessor
    val minusThree = minusTwo.predecessor
    val minusFour = minusThree.predecessor
    val minusFive = minusFour.predecessor
    val minusSix = minusFive.predecessor
    val minusSeven = minusSix.predecessor
    val minusEight = minusSeven.predecessor
    val minusNine = minusEight.predecessor
    val minusTen = minusNine.predecessor
  }

  test("successor of the predecessor of a number is its self") {
    new SomeNumbers {
      assert(zero.successor.predecessor == zero)
      assert(one.successor.predecessor == one)
      assert(minusFour.successor.predecessor == minusFour)
    }
  }

  test("predecessor of the successor of a number is its self") {
    new SomeNumbers {
      assert(zero.predecessor.successor == zero)
      assert(one.predecessor.successor == one)
      assert(minusFour.predecessor.successor == minusFour)
    }
  }

  test("zero is neutral under addition") {
    new SomeNumbers {
      assert(zero + zero == zero, "0 + 0 == 0")
      assert(zero + one == one, "0 + 1 == 1")
      assert(one + zero == one, "1 + 0 == 1")
      assert(minusOne + zero == minusOne, "-1 + 0 == -1")
      assert(zero + minusFive == minusFive, "0 + (-5) == -5")
    }
  }

  test("zero is neutral when subtracted from another number") {
    new SomeNumbers {
      assert(zero - zero == zero, "0 - 0 == 0")
      assert(one - zero == one, "1 - 0 == 1")
      assert(minusThree - zero == minusThree, "-3 - 0 == -3")
    }
  }

  test("number is inverted when subtracted from zero") {
    new SomeNumbers {
      assert(zero - two == minusTwo, "0 - 2 == -2")
      assert(zero - one == minusOne, "0 - 1 == -1")
      assert(zero - minusTwo == two, "0 - (-2) == 2")
      assert(zero - minusOne == one, "0 - (-1) == 1")
    }
  }

  test("integers can sum one with others") {
    new SomeNumbers {
      assert(five + one + two == eight, "5 + 1 + 2 == 8")
      assert(five + minusSix + two == one, "5 + (-6) + 2 == 1")
      assert(three + minusSeven + minusOne == minusFive, "3 + (-7) + (-1) == -5")
      assert(minusTen + four + minusOne == minusSeven, "-10 + 4 + (-1) == -7")
      assert(minusTen + four + six == zero, "-10 + 4 + 6 == 0")
    }
  }

  test("sum is commutative property") {
    new SomeNumbers {
      assert(five + one == one + five, "5 + 1 == 1 + 5")
      assert(two + three == three + two, "2 + 3 == 3 + 2")
      assert(minusTwo + three == three + minusTwo, "-2 + 3 == 3 + (-2)")
    }
  }

  test("integers can subtract one with other") {
    new SomeNumbers {
      assert(five - one - two == two, "5 - 1 - 2 == 2")
      assert(five - minusSix - two == nine, "5 - (-6) - 2 == 9")
      assert(three - minusSix - minusOne == ten, "3 - (-6) - (-1) == 10")
      assert(minusTwo - four - minusOne == minusFive, "-2 - 4 - (-1) == -5")
      assert(minusTwo - minusFive - three == zero, "-2 - (-5) - 3 == 0")
    }
  }

  test("positive number subtracted by another positive number") {
    new SomeNumbers {
      assert(five - three == two)
      assert(five - five == zero)
      assert(four - seven == minusThree)
    }
  }

  test("negative number subtracted by another negative number") {
    new SomeNumbers {
      assert(minusFive - minusThree == minusTwo)
      assert(minusFive - minusFive == zero)
      assert(minusFour - minusSeven == three)
    }
  }

  test("no number is smaller than it self") {
    new SomeNumbers {
      assert(!(zero < zero))
      assert(!(five < five))
      assert(!(minusTwo < minusTwo))
    }
  }

  test("zero is smaller than any positive number") {
    new SomeNumbers {
      assert(zero < one)
      assert(zero < two)
      assert(zero < five)
    }
  }

  test("zero is not smaller than any negative number") {
    new SomeNumbers {
      assert(!(zero < minusOne))
      assert(!(zero < minusTwo))
      assert(!(zero < minusFive))
    }
  }

  test("positive numbers aren't smaller than any not positive number") {
    new SomeNumbers {
      assert(!(two < zero))
      assert(!(three < minusTwo))
      assert(!(one < minusFive))
    }
  }

  test("a positive number is smaller than another positive number if it is closer to zero") {
    new SomeNumbers {
      assert(two < three)
      assert(two < four)
      assert(four < five)
      assert(!(four < two))
      assert(!(eight < one))
    }
  }

  test("negative numbers are always smaller than any not negative number") {
    new SomeNumbers {
      assert(minusTwo < zero)
      assert(minusThree < two)
      assert(minusOne < five)
    }
  }

  test("a negative number is not smaller than any another negative number if it is closer to zero") {
    new SomeNumbers {
      assert(!(minusTwo < minusFour))
      assert(minusFive < minusOne)
    }
  }

  test("zero is smaller or equal to zero") {
    new SomeNumbers {
      assert(zero <= zero)
    }
  }

  test("zero is smaller or equal to positive numbers") {
    new SomeNumbers {
      assert(zero <= one)
      assert(zero <= six)
    }
  }

  test("zero is not smaller or equal to negative numbers") {
    new SomeNumbers {
      assert(!(zero <= minusOne))
      assert(!(zero <= minusSix))
    }
  }

  test("positive numbers and 'smaller or equal to' operator") {
    new SomeNumbers {
      assert(one <= one)
      assert(one <= five)
      assert(!(five <= one))
      assert(!(two <= zero))
      assert(!(two <= minusTen))
    }
  }

  test("negative numbers and 'smaller or equal to' operator") {
    new SomeNumbers {
      assert(minusTwo <= minusTwo)
      assert(minusTwo <= minusOne)
      assert(!(minusTwo <= minusThree))
      assert(minusTwo <= zero)
      assert(minusTwo <= ten)
    }
  }

  test("zero and 'greater' operator") {
    new SomeNumbers {
      assert(!(zero > zero))
      assert(!(zero > one))
      assert(zero > minusOne)
    }
  }

  test("positive numbers and 'greater' operator") {
    new SomeNumbers {
      assert(one > zero)
      assert(!(one > one))
      assert(!(one > five))
      assert(one > minusFive)
    }
  }

  test("negative numbers and 'greater' operator") {
    new SomeNumbers {
      assert(!(minusOne > zero))
      assert(!(minusOne > minusOne))
      assert(!(minusOne > five))
      assert(minusOne > minusFive)
    }
  }

  test("zero and 'greater or equal' operator") {
    new SomeNumbers {
      assert(zero >= zero)
      assert(!(zero >= one))
      assert(zero >= minusOne)
    }
  }

  test("positive numbers and 'greater or equal' operator") {
    new SomeNumbers {
      assert(one >= zero)
      assert(one >= one)
      assert(!(one >= five))
      assert(one >= minusFive)
    }
  }

  test("negative numbers and 'greater or equal' operator") {
    new SomeNumbers {
      assert(!(minusOne >= zero))
      assert(minusOne >= minusOne)
      assert(!(minusOne >= five))
      assert(minusOne >= minusFive)
    }
  }
}
