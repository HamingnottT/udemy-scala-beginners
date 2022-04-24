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

    def main(args: Array[String]) = {
        // println(sum(3))
        // println(sumPositive())
    }
}
