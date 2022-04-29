import scala.io.StdIn.readLine
import scala.annotation.tailrec

// for minimum cost
import java.io._
import scala.util.control.Breaks._
import scala.collection.immutable.Vector._

import scala.collection.mutable.ListBuffer


object Recursion {

    def getMinCost(N: Int,X: Int, A: Array[Int], B: Array[Int]): Int = {
        // N = number of types of chocolates
        // X = kilograms desired
        // A = types of chocolates mapped into an array
        // B = cost array

        // each element of array A determines the amount of chocolate (in kg) and Array B determines the cost of the each element in A.
        // expression relationship: (1=i<=N)

        // aux function to get possible factors of X

        def factors(X: Int): Unit = {
            var container = new ListBuffer[Int]()
            def factorsHelper(elementOfX: Int, isFactor: Boolean): ListBuffer[Int] = {
                if (isFactor) container += X
                else factorsHelper(elementOfX - 1, X % elementOfX != 0 && isFactor)
            }
            factorsHelper(X, true)
        }

        println(factors(X))


        return 5 // dummy return type so the compiler doesnt complain

        // val result = ""
        // return result
    }
    
    def minCostInput(): Unit = {
        // INPUT [uncomment & modify if required]
        val N: Int = readLine.toInt
        val X: Int = readLine.toInt
        
        val A: Array[Int] = readLine.split(" ").map(_.toInt)
        val B: Array[Int] = readLine.split(" ").map(_.toInt)

        // OUTPUT [uncomment & modify if required]
        print(getMinCost(N,X,A,B))
    }


    def menu(): Unit = {
        var close_program = false

        def menuOptions(): Unit = {
            println(s"""\nPlease input an the corresponding number to view exercise answers:
                        |
                        |1.     Placeholder
                        |
                        |99.    Print menu options
                        |0.     Exit program
                        |""".stripMargin)
        }

        menuOptions()

        while(!close_program) {
            var option = readLine("Input option: ").toInt
            
            if (option == 1) {
                println("\n")
                
                println("\n")
            }
            else if (option == 99) {
                menuOptions()
            }
            else if (option == 0) {
                println("\nExiting program. . .")
                close_program = true
            }
            else println(s"\nInvalid reponse please try again.\n")
        }

    }

    
    def main(args:Array[String]): Unit = {

    }
}