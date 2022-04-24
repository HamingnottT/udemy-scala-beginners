// package independant.recursion.marklewis

import scala.io.StdIn.readLine

// for debug timestamp
import java.util.Calendar
import java.text.SimpleDateFormat
import java.sql.Timestamp

object recursionForIteration {

    // debug timestamp
    def getCurrentdateTimeStamp: Timestamp ={
        val today:java.util.Date = Calendar.getInstance.getTime
        val timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val now:String = timeFormat.format(today)
        val re = java.sql.Timestamp.valueOf(now)
        re
    }

    // this is an example of a unit function using recursion
    def countDownRec(n: Int): Unit = {
        if (n > 0) {            //defines the base case
            println(n)
            countDownRec(n-1)
        }
    }
    
    def countDownLoop(n: Int): Unit = {
        var m = n               //a new variable m had to be assigned because n in function is considered immutable val
        for (i <- 1 to n) {     //iterates thru range of 1 until n
            println(m)
            m -= 1              //decrements m until end of for loop
        }
    }

    // recursive example of counting up
    def countUpFromTo(from: Int, to: Int): Unit = {
        if(from <= to) {         //in this case, the condition of the base case is reversed where 'from' is less than or equal to 'to'
            println(from)
            countUpFromTo(from + 1, to) //the recursive call is also reversed where now we add 1 to the value of 'from' each recursive call
        }
    }


    def main(args: Array[String]) = {
        println(s"\n${"="*48}\n")
        
        println("Count down example:")

        var n = readLine("Input a number here: ").toInt
        
        println("\nRecursive example:\n")

        println(getCurrentdateTimeStamp)
        countDownRec(n)
        println(getCurrentdateTimeStamp)

        println("\nFor loop example:\n")

        println(getCurrentdateTimeStamp)
        countDownLoop(n)
        println(getCurrentdateTimeStamp)

        println("\nCount up example:\n")

        val from = readLine("Count up From: ").toInt
        val to = readLine("Count Up To: ").toInt

        println(getCurrentdateTimeStamp)
        countUpFromTo(from, to)
        println(getCurrentdateTimeStamp)

        println(s"\n${"="*48}\n")
    }
}
