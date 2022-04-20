package lectures.part1basics

object valuesVariableTypes extends App {
  
    // Vals
    /*Vals are used in Scala to store certain values or results of a particular function
     * 
     */

    val x: Int = 24                 // The conventional syntax of declaring an immutable variable val
    var y: Int = 24                 // The conventional syntax of declaring an mutable variable val

    // Note: val is immutable and var is mutable

    val z = 88                      // The compiler can infer types, so adding the type is not often necessary

    // examples of vals

    val aString: String = "Hello, World"    // Strings are often denoted with double quotes
    val anotherString = "Goodbye, World"

    val aBoolean: Boolean = false
    val aChar: Char = 'a'           // Characters are often denoted with single quotes
    val anInt: Int = x              // You can assign a variable as a value of another variable
    val aShort: Short = 4613        // Shorts numbers at only 2 bytes of memory; The default size of an Int is 4 bytes
    val aLong: Long = 461352789561518152L     // Longs are stored at 8 bytes of memory; to store a long you must put an 'L' at the end
    val aFloat: Float = 2.0f        // Floats are single floating point numbers; to store a float you must put 'f' at the end or else it will be stored as a double
    val aDouble: Double = 3.14      // Doubles can have multiple floating points at the end

    // varables
    /* Variables are mutable and often used as side effects
     * side effects are useful because the allow us to see what our programs are doing
     * like changing a variable or displaying something to the console
     */ 
    
    var aVar: Int = 4

    aVar = 5                        // Variables can be reassigned
    


}
