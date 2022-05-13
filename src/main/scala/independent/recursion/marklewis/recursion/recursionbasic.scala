// package independant.recursion.marklewis

import scala.io.StdIn._
object RecursionBasic {

    // factorial example
    def factorial(n: BigInt): BigInt = {
        if(n < 2) 1
        else n * factorial(n - 1)
    }

    // sum of squares example
    def sumSquares(n: Int): Int = {
        if(n < 2) 1
        else n * n + sumSquares(n - 1)
    }

    // build list example - made buildlist auxillary to keep main clean
    def example2() = {
        def buildlist(): List[String] = {
            val input = readLine("Input a string here('quit' to stop): ")
            if (input == "quit") Nil
            else input :: buildlist()       //the :: operator adds the user input to the beginning of the list
        }
        val lst = buildlist()
        println(lst)
        
        // this takes the prior list and concatenates the strings together into one string
        def concatStrings(words: List[String]): String = {
            if (words.isEmpty) ""
            else words.head + concatStrings(words.tail)
        }
        println(concatStrings(lst))

        // this is the same recursive function as above but using match-case instead
        // the :: is called a cons operator and it is used when dealing with a head and tail of a collection
        // pattern matching is more common when dealing with strings in Scala
        def concatStringsPat(words: List[String]): String = words match {
            case Nil => ""
            case h :: t => h + concatStringsPat(t)
        }
        println(concatStringsPat(lst))
    }
    

    def main(args: Array[String]) = {
        println(s"\n ${"="*48} \n")
        
        println("Factorial example:")
        println(factorial(5))

        println("Sum of squares example:")
        println(sumSquares(4))

        // println("Build list example:")
        // example2()

        println(s"\n ${"="*48} \n")
    }
}