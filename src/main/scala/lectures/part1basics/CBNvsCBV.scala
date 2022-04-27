package lectures.part1basics

/** Call by name and Call by value
 * These are Scala-specific methods to use
*/

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  /** Notes on the above functions:
   * Typically we define a function by calling by value: def calledByValue(x: Long), where x is specified as a Long value type
   * 
   * Calling by name is similar by different syntax. We call by value using the '=>', or arrow in this case, pointing the the value type.
   * 
  */

  // calledByValue(1257387745764245L)
  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  /**
   * A by value call computes the exact value of the expression before the function evaluates
   * 
   * A by name call the expression evaluates along with the function and returns the value as-is
   * this results in different values when calling the time function
   * calling by name is extremely useful in lazy streams and in things that might fail
  */

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //  printFirst(infinite(), 34) // stack overflow
  printFirst(34, infinite())

  /**
   * Calling infinite() first forces the function to evaluate first as it is in the x position
   * This results in a stack overflow because infinite() is by nature an infinite loop
   * 
   * However, passing infinite() into the y position will call infinite() by name, but because y is never used in the function printFirst(), infinite() would never be evaluated
  */
}
