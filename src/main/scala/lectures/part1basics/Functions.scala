package lectures.part1basics

object Functions extends App {

/** Main ideas:
  * 1. A function is treated like an expression
  * 2. Parameterless functions can be called only by their names
  * 3. Instead of loops, use functions (Recursion used in example)
  * 4. Recursive functions need to have a result type specified or else the compiler complains
  * 5.
  */

  // this is the standard definition of a function
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

/** Regarding the above function:
  * In Scala, you don't necessarily need {} do define a function
  * The above function can also be written as the following:
  * 
  * def aFunction(a: String, b: Int): String =
  * a + " " + b
  */

  // Parameterless Functions
  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  // println(aParameterlessFunction) // only works in Scala 2 - parameterless functions are invoked without parentheses

  // using recursive functions as a substitute for loops
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString                               // if n = 1, it returns only the value of aString once
    else aString + aRepeatedFunction(aString, n-1)    // but if n != 1, it not only returns the value of aString, but the function calls itself defining aString, and evaluating n-1 until n reaches 1
  }

  println(aRepeatedFunction("hello",3))               // because of the recursion, the function will iterate 3 times until n reaches 1

  // WHEN YOU NEED LOOPS, USE RECURSION.

  /** Note to self:
     * review heavily on recursion. it seems like something like this 
     * is best done when n counts down, and not up like a for loop
    */


  /** becuase this Unit type function has an expression that returns a sideffect,
     * calling this function will result in printing Hello to the console despite the return type being Unit
     * We normally need functions with side effects if we want something that has nothing to do with computation like:
     * - printing to console/logging
     * - writing to a file
    */

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b     // this is an auxillary function

    aSmallerFunction(n, n-1)                              // calling the aux function can only be in the parent function
  }

  /*
    Exercises:
    1.  A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
    2.  Factorial function 1 * 2 * 3 * .. * n
    3.  A Fibonacci function
        f(1) = 1
        f(2) = 1
        f(n) = f(n - 1) + f(n - 2)
    4.  Tests if a number is prime.
   */

  def greetingForKids(name: String, age: Int): String =
    "Hi, my name is " + name + " and I am " + age + " years old."
  println(greetingForKids("David", 12))

  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n-1)

  println(factorial(5))

  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)

  // 1 1 2 3 5 8 13 21
  println(fibonacci(8))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n / 2)
  }
  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))
}
