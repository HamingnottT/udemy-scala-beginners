
import scala.io.StdIn.readLine

object Recursion1 {

    def greeting(name: String, age: Int): Unit = {
        println(s"Hi, my name is ${name} and I am ${age} years old")
    }
    
    def factorial(n: Int): Int = {
        if (n < 1) 1
        else n * factorial(n - 1)
    }

    def fibonacci(n: Int): Int = {
        if (n <= 2) 1
        else fibonacci(n - 1) + fibonacci(n - 2)
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
            else if (option == 99) {
                menuOptions()
            }
            else if (option == 0) {
                close_program = true
            }
            else println(s"\nInvalid reponse please try again.\n")
        }

        println("\nExiting program. . .")
    }

    def main(args: Array[String]): Unit = {
        menu()
        
    }
}