package exercises.part1basics

object expressions extends App {
    println(s"\n ${"="*48} \n") //buffer for 'sbt run'

    println("1. What is the difference between 'Hello World' vs println('Hello World')?")
    println("\n")
    println("'Hello World' is an literal of a string type, and println('Hello World') is an expression which is a side effect of printing 'Hello World to the console'.")
    println("\n")
    
    val someValue = {
        2 < 3
    } //returns type Bool
    
    println(someValue)

    val someOtherValue = {
        if(someValue) 239 else 986
        42
    } //returns type Int
    // returns 42 because it is the last expression of the block; the conditional is ignored

    println(someOtherValue)

    println(s"\n ${"="*48} \n")
}
