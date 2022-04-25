// package independant.recursion.marklewis

import scala.io.StdIn._

object RecursionInput {
    // this recursive function takes a fix number n of custom inputs and produces the sum of all inputs 
    def sum(n: Int): Int = {
        if(n < 1) 0
        else {
            val input = readInt
            input + sum(n - 1)
        }
    }

    // this function doesnt take any arguments because the user is the one that defines the base case
    // or however many inputs there are. this recursive loop is terminated when the user inputs a negative number
    def sumPositive(): Int = {
        val input = readInt
        if (input >= 0) {
            input + sumPositive()
        } else 0
    }

    def sumUntilQuit(): Int = {
        val input = readLine.toLowerCase.trim
        if (input == "quit") 0
        else input.toInt + sumUntilQuit()
    }

    // this function takes user input until they type in quit
    // this function also returns how many number inputs were added
    // you can have multiple return types specified after the colon
        // note: if more than one return type is specified then there MUST be multiple return definitions
    def sumAndCount(): (Int, Int) = {
        val input = readLine.toLowerCase.trim
        if (input == "quit") (0, 0)             //quits and addes zero to oboth the return sum and the return count
        else {
            val (sum, count) = sumAndCount()
            (input.toInt + sum, count + 1)      //input adds to the sum and the count is incremented by 1
        }
    }

    def main(args: Array[String]): Unit = {
        // println(sum(3))
        // println(sumPositive())
        // println(sumUntilQuit())
        // println(sumAndCount())

        // how to obtain the average from the sumAndCount function
        val (s, c) = sumAndCount()
        println(s"sum: ${s}, count: ${c}")
        println(s"This is the average sum to count ${s/c.toDouble}")
    }
}
