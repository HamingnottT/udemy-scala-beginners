package exercises.part1basics

// for user inputs
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

object functions extends App {
    println(s"\n${"="*48}\n")
    //1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
    println("\n1.\n")
    def greeting(name : String, age : Int) = {
        println(s"Hi, my name is $name and I am $age years old.")
    }
    
    val name = readLine("What is your name? ")
    val age = readLine("What is your age? ").toInt

    greeting(name, age)

    println("\n2.\n")
    
    // 2.  Factorial function 1 * 2 * 3 * .. * n
    def factorial(n : Int): Int = {
        if (n <= 0) 1
        else n * factorial(n-1)
    }
    println(factorial(5))

    println("\n3.\n")
    /**3.  A Fibonacci function
      *  f(1) = 1
      *  f(2) = 1
      *  f(n) = f(n - 1) + f(n - 2)
      * 
      * 1 1 2 3 5 8 13 21
      */

    def fibo(n: Int): Int = {
        if (n <= 2) 1
        else fibo(n-1) + fibo(n-2)
    }

    println(fibo(8))        // this function returns the last fibonacci number of n

    println("\n4.\n")
    //4.  Tests if a number is prime.
    // attempt #1:
    def prime1(n: Int): String = 
        if (n % 2 == 1 || n == 2) "This number is prime."
        else "This number is composite."

    // answer key answer
    def isPrime(n: Int): Boolean = {
        def isPrimeUntil(t: Int): Boolean =
            if (t <= 1) true
            else n % t != 0 && isPrimeUntil(t - 1)
        isPrimeUntil(n / 2)
    }
    /** What's happening in the answer key answer?
     * The return type of the main function is Boolean
     * There is an auxillary recursive function created that iterates through oll of the possible divisors starting from n/2 until  1
     * in the else expression, there is a mod expression and a logical and expression. What's going on?
     *  - essentially, we need to make sure that t <= 1, so if any of the possible 'n' values divide evenly with 't', 
     *      then we force a 'false' boolean by stating n % t != 0, which will continue the recursion
    */

    val n = readLine("Give me a number: ").toInt
    println(s"Attempt 1 answer: ${prime1(n)}")
    println(s"Answer key answer: ${isPrime(n)}")

    // The takeaway? Both answers work
    /** Note to self:
     * review heavily on recursion. it seems like something like this 
     * is best done when n counts down, and not up like a for loop
    */

    println(s"\n${"="*48}\n")
}
