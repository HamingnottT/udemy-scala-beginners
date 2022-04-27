package exercises.part1basics

import scala.annotation.tailrec
import scala.io.StdIn.readLine

// import scala.compiletime.ops.string

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
        */

    // 2) fibonacci tail recursion
        // 1. My attempt
    // def fiboTail(n: Int, accmulator: Int): Int =
    //     if (n <= 2) accmulator
    //     else fiboTail(n - 1, n + accmulator)

    def fiboTail(n: Int): Int = {
        @tailrec
        def fiboHelper(n: Int, accmulator: Int): Int =
            if (n <= 2) accmulator
            else fiboHelper(n - 1, n + accmulator)

        fiboHelper(n, 1)
    }


    def main(args: Array[String]): Unit = {
        var inputStr = readLine("Input string: ")
        var inputInt = readLine("Input number: ").toInt
        
        println(stringConcat(inputStr, inputInt))
        println(concatenateTailrec(inputStr, inputInt, ""))


        println(fiboTail(8))
    }

}
