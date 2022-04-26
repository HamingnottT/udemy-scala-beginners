package lectures.part1basics

import scala.io.StdIn.readLine

import scala.annotation.tailrec       //essential import for tail recursion

/** About the JVM:
 * in order to run a recursive function, the JVM uses a call stack to keep partial results
 * so that it can get back to computing the desired result.
 * This call stack can be vizualized as a stack of books. Each time you add a book, you stack one on top of the other.
 * The call stack is similar to this as it organizes calls in the aformentioned exampled.
 * The call stack also executes in a last-in-first-out way.
*/

object Recursion extends App {
  var counter = 0
  // example of a stack frame analysis using the factorial function
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      // println("Part 1 - Pre-evaluation:\n")
      println(s"Frame ${counter + 1}: " + "Computing factorial of " + n + " - I first need factorial of " + (n-1))
      counter += 1
      val result = n * factorial(n-1)
      // println("Part 2 - base case reached, now evaluating:\n")
      println(s"Frame ${counter + 1}: " + "Computed factorial of " + n)
      counter += 1

      result
    }

  var input = 10
  println(s"\nCall stack analysis of factorial(${input}):\n")
  println(factorial(input))
  //  println(factorial(5000)) // stack overflow!

  counter = 0

  def anotherFactorial(n: Int): BigInt = {
    @tailrec  //this annotation tells the compiler to verify and treat this function as tail recursive
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else {
        println(s"test start ${counter + 1}")
        counter += 1
        factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression
      }

    factHelper(n, 1)
  }

  /** Adding an auxillary function with an accmulator works well to prevent a stack overflow error.
   * The accumulator's job is to record and accumulate each subsequent value on the recursive call.
   * 
   * The trick in this example is that the factHelper() function is the last expression of anotherFactorial's codepath.
   * Because of this, Scala preserves the same stack frame and does not use additional stack frames for recursive calls.
   * 
  */

  /*
    Breakdown:
    
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)
    = factHelper(1, 1 * 2 * 3 * 4 * ... * 10)
    = 1 * 2 * 3 * 4 * ... * 10
   */
    println(s"\nCall stack analysis of anotherFactorial(${input}):\n")
   println(anotherFactorial(input))
  // println(anotherFactorial(20000))

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION.

  /*
    Exercises:
    1.  Concatenate a string n times
    2.  IsPrime function tail recursive
    3.  Fibonacci function, tail recursive.
   */

  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailrec(aString, n-1, aString + accumulator)

  println(concatenateTailrec("hello", 3, ""))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8)) // 1 1 2 3 5 8 13, 21
}
