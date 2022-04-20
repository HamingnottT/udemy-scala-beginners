package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2               // example of an EXPRESSION
  println(x)

  println(2 + 3 * 4)          // an example of a math expression
  // + - * / & | ^ << >> >>> (right shift with zero extension)
  
  /** Some extra notes:
   * Math operators: + - * /
   * Bitwise operators: 
   * &, |, ^ (and, or, xor respectively)
   * <<, >>, >>> (left-shift, right-shift, and right shift with zero extension)
   */

  println(1 == x)             // an example of a conditional expression
  //, ==, !=, >, >=, <, <=

  println(!(1 == x))          // an example of a logical operation on a conditional expression
  //, !, &&, || (not, and, or respectively)

  // incrementation example:
  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ..... these are all side effects
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)
  
  /** An instruction is something you tell the computer to DO
   * An expression is something that the computer does that results in a VALUE or TYPE
  */

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN.

  // EVERYTHING in Scala is an Expression!

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // 1. difference between "hello world" vs println("hello world")?
  // 2.

  val someValue = {
    2 < 3
  }
  println(someValue)

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  println(someOtherValue)

}
