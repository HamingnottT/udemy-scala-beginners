
import java.io._
import scala.util.control.Breaks._
import scala.collection.immutable.Vector._

import scala.collection.mutable.ListBuffer

object Test {
    def factors(X: Int): ListBuffer[Int] = {
        var container = new ListBuffer[Int]()
        def factorsHelper(elementOfX: Int): ListBuffer[Int] = {
            if (elementOfX <= 1) container += elementOfX
            else factorsHelper(elementOfX - 1)
        }
        factorsHelper(X)
        return container
    }

    def main(args: Array[String]): Unit = {
        var test = new ListBuffer[String]()
        test += "Hello"
        test += "test"
        println(test)
        println(factors(5))
    }
}
