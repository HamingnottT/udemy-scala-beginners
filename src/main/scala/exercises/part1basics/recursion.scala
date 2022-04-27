package exercises.part1basics

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object recursion {
    
    // 1) string concatenator
        // 1. My attempt:
    def stringConcat(str: String, n: Int): String = {
        @tailrec
        def concatHelper(n: Int, accumulator: String): String = 
            if (n == 1) accumulator
            else concatHelper(n - 1, str + accumulator)

        concatHelper(n, str)
    }

        // 2. Answer key:
    def concatenateTailrec(aString: String, n: Int, accumulator: String): String =
        if (n <= 0) accumulator
        else concatenateTailrec(aString, n-1, aString + accumulator)

        /**Notes: my attempt came out pretty close to daniel's solution.
         * Mine was modeled heavily after the original string concat function in lectures/functions.scala
         * with elements of the tail recurion function just learned in lectures/Recursion.scala.
         * 
         * Both solutions work quite well. What can be taken away from this exercise is that the tail recursion function can be
         * optimized further, taking the accumulator in the main function and thus no longer needing an auxillary function to help the main.
         * 
         * Accumulators need to have the same type as the functions return type. Because the return of the above function is a string, the accumulator must be a string
        */

    // 2) fibonacci tail recursion
        // 1. My attempt
    // def fiboTail(n: Int, accmulator: Int): Int =
    //     if (n <= 2) accmulator
    //     else fiboTail(n - 1, n + accmulator)

    // def fiboTail(n: Int): Int = {
    //     @tailrec
    //     def fiboHelper(n: Int, accmulator: Int): Int =
    //         if (n <= 2) accmulator
    //         else fiboHelper(n - 1, n + (accmulator - 1))

    //     fiboHelper(n, 1)
    // }

    // 2. Answer key answer:
    def fibonacci(n: Int): Int = {
        @tailrec
        def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =      
            if(i >= n) last
            else fiboTailrec(i + 1, last + nextToLast, last)

        if (n <= 2) 1
        else fiboTailrec(2, 1, 1)
    }

    /** Original function:
     *
     * def fibo(n: Int): Int = {
     *      if (n <= 2) 1
     *      else fibo(n-1) + fibo(n-2)
     * }
     * 
     * This tail recursive example of the fibonacci function is a works in adding order.
     * 'last' is the first accumulator representing (n - 1) and 'nextToLast' is representative of (n - 2).
     * The if conditional in the main function, optimizes the function by making sure to return 1 at value n <= 2,
     * greater values run through the auxillary function.
    */

    // 3) prime number checker
    def isPrime(n: Int): Boolean = {
        @tailrec
        def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = // isStillPrime is the accumulator
            if(!isStillPrime) false
            else if(t <= 1) true
            else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime) 

        isPrimeTailrec(n / 2, true)             //isStillPrime is assumed true at the execution of the function
    }
    /** Original non tail-recursive function:
     *
     *  def isPrime(n: Int): Boolean = {
     *      def isPrimeUntil(t: Int): Boolean =
     *          if (t <= 1) true
     *          else n % t != 0 && isPrimeUntil(t - 1)
     *      isPrimeUntil(n / 2)
     *  }
     * 
     * In the tail-recursive example of this, the accumulator is isStillPrime. because the return type is Boolean, isStillPrime must be boolean.
     * for this example's logic, isStillPrime is assumed to be true.
     * the accumulator isStillPrime stores the boolean value of 'n % t != 0'
     * It still also is fixed to where when it is called recursively, isStillPrime is assumed initially true
    */


    def main(args: Array[String]): Unit = {
        var inputStr = readLine("Input string: ")
        var inputInt = readLine("Input number: ").toInt
        
        println(stringConcat(inputStr, inputInt))
        println(concatenateTailrec(inputStr, inputInt, ""))


        println(s"Fibonacci number of index ${inputInt}: ${fibonacci(inputInt)}")

        println(s"Is this number prime? ${isPrime(inputInt)}")
    }

}
