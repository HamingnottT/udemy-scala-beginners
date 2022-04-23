package playground

object functions extends App {
    println(s"\n${"="*48}\n")

    /** becuase this Unit type function has an expression that returns a sideffect,
     * calling this function will result in printing Hello to the console despite the return type being Unit
     * We normally need functions with side effects if we want something that has nothing to do with computation like:
     * - printing to console/logging
     * - writing to a file
    */
    def aFunctionWithSideEffects(aString: String): Unit = println(aString)
    aFunctionWithSideEffects("Hello")
    
    
    
    println(s"\n${"="*48}\n")
}
