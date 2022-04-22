package lectures.part1basics

object Expressions extends App {

  /** Main Ideas:
   * Instructions are executed (think Java), expressions are evaluated (Scala)
  */

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
  /** A few notes about the IF expression:
   * 1. To test whether aCondition is True, we simply write "if(aCondition)" - the more explicit "if(aCondition == true)" is optional
   *  - more on 1., IF conditionals can be one-liners in Scala
   * 2. IF expressions are different from IF statements because the former returns a value, and NOT an instruction (e.g. set aCondition to value of 5, else 3)
   */

  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)                      // returns 5, b/c aCondition is 'true'
  println(if(aCondition) 5 else 3)                // same operation, but made explicit
  println(1 + 3)                                  

  // NOTE: ALL IF conditional in Scala are expressions b/c they can return a value and not just a command!

  // While Loops
  /** Notes on Loops: 
   * while loops are discouraged b/c they are reminiscent of imperative programming like Java
   * - they don't return anything meaningful and only execute side effects
  */

  var i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN.
  /** Daniel elaborates by saying that its because while and looping in general is very specific to imperative programming
   * - like Java, Python, or C
   * - in Scala, any imperative code should be avoided because of its nature explained below
  */

  // EVERYTHING in Scala is an Expression!
  /** This is the most likely the reason behind avoiding while loop and anything imperative
   * Only definitions like the definition of a vowel or a class or package are not expressions, but everything else is
  */

  // Side effects and Unit types
  /** Unit is equivelent to void in other languages
   *    - this tells the compiler to not return anything meaningful
   *    - the only possible value of Unit is Unit
   * 
   * Side effects are expressions that return a Unit type
  */

  val aWeirdValue = (aVariable = 3) // Unit === void 
  println(aWeirdValue)              // all units return '()' - not very meaningful, indeed

  // side effects: println(), while loops, reassigning

  // Code blocks
  /** Code blocks are expressions that hold special properties
   *    - The value of the code block is the value of the last element of its last expression
   * Code blocks can have their own definition of values inside the code block
   *    - any values declared in a code block stay in the code block
  */

  val aCodeBlock = {
    val y = 2         // these are called auxillary definitions
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }
  // this returns a string which is declared by the if expression at the end of the code block

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
