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
}
