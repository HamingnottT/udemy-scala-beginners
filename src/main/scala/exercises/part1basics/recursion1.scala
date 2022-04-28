
import scala.io.StdIn.readLine
import scala.annotation.tailrec

object Recursion1 {
    
    def greeting(name: String, age: Int): Unit = {
        println(s"Hi, my name is ${name} and I am ${age} years old")
    }
    
    def factorial(n: Int): Int = {
        if (n <= 1) 1
        else n * factorial(n - 1)
    }

    def fibonacci(n: Int): Int = {
        if (n <= 2) 1
        else fibonacci(n - 1) + fibonacci(n - 2)
    }

    def isPrime(n: Int): Boolean = {
        def isPrimeUntil(t: Int): Boolean = {
            if (t <= 1) true
            else n % t != 0 && isPrimeUntil(t-1)
        }
        isPrimeUntil(n / 2)
    }

    def factorialAlt(n: Int, accmulator: Int): Int = {
        if (n <= 1) accmulator
        else factorialAlt(n - 1, n * accmulator)
    }

    def factorialTailrec(n: Int): Int = {
        @tailrec
        def factHelper(m: Int, accmulator: Int): Int = {
            if (m <= 1) accmulator
            else factHelper(m - 1, m * accmulator)
        }
        factHelper(n, 1)
    }

    def fiboTailrec(n: Int): Int = {
        def fiboTailrecHelper(m: Int, last: Int, nextToLast: Int): Int = {
            if (m >= n) last
            else fiboTailrecHelper(m + 1, last + nextToLast, last)
        }
        if (n <= 2) 1
        else fiboTailrecHelper(2, 1, 1)
    }

    def isPrimeTailrec(n: Int): Boolean = {
        @tailrec
        def isPrimeTailrecHelper(t: Int, isStillPrime: Boolean): Boolean = {
            if (!isStillPrime) false
            else if (t <= 1) true
            else isPrimeTailrecHelper(t - 1, n % t != 0 && isStillPrime)
        }
        isPrimeTailrecHelper(n / 2, true)
    }



    def tailrecMenu(): Unit = {
        var close_menu = false
        def menuOptions(): Unit = {
            println(s"""\nThis is a better way of executing exercises problems.
                        |Please input an the corresponding number to view exercise answers:
                        |
                        |1.     Factorial function
                        |2.     Fibonacci function
                        |3.     Prime number checker
                        |99.    Print menu options
                        |0.    Previous menu
                        |""".stripMargin)
        }

        menuOptions()

        while(!close_menu) {
            var option = readLine("Input option: ").toInt

            if (option == 1) {
                println("\n")
                println(factorialTailrec(n=readLine("n = ").toInt))
                // println(factorialAlt(1, 1))
                println("\n")
            }
            else if (option == 2) {
                println("\n")
                println(fiboTailrec(n=readLine("n = ").toInt))
                println("\n")
            }
            else if (option == 3) {
                println("\n")
                println(isPrimeTailrec(n=readLine("n = ").toInt))
                println("\n")
            }
            else if (option == 99) {
                menuOptions()
            }
            else if (option == 0) {
                println("\nReturning to main menu. . .")
                return
            }
            else println(s"\nInvalid reponse please try again.\n")
        }
    }

    def menu(): Unit = {
        var close_program = false

        def menuOptions(): Unit = {
            println(s"""\nThis is a better way of executing exercises problems.
                        |Please input an the corresponding number to view exercise answers:
                        |
                        |1.     Name greeting
                        |2.     Factorial function
                        |3.     Fibonacci function
                        |4.     Prime number checker
                        |5.     Tail recursion
                        |99.    Print menu options
                        |0.     Exit program
                        |""".stripMargin)
        }
        
        menuOptions()

        while(!close_program) {
            var option = readLine("Input option: ").toInt

            if (option == 1) {
                println("\n")
                greeting(name=readLine("What is your name? "), age=readLine("How old are you? ").toInt)
                println("\n")
            }
            else if (option == 2) {
                println("\n")
                println(factorial(n=readLine("n = ").toInt))
                println("\n")
            }
            else if (option == 3) {
                println("\n")
                println(fibonacci(n=readLine("n = ").toInt))
                println("\n")
            }
            else if (option == 4) {
                println("\n")
                println(isPrime(n=readLine("n = ").toInt))
                println("\n")
            }
            else if (option == 5) {
                tailrecMenu()
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

    def main(args: Array[String]): Unit = {
        menu()
        
    }
}