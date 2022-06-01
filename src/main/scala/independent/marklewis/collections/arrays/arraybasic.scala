// package independent.recursion.marklewis.arrays

import scala.io.StdIn._

object ArrayBasic {
    
    def arraysIntro(): List[Int] = {
        // syntax o building an array
        val a = Array(7, 5, 9, 3, 2)
        List(a(0), a(1))
    }
    
    def main(args: Array[String]): Unit = {
        println(arraysIntro())
    }
}