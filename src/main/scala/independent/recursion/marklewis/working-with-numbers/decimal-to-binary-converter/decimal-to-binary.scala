import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
object DecToBin {
    def getBinary(num: Int): String = {
        var newNum: Int = num
        var newList: ListBuffer[Int] = ListBuffer()
        
        while (newNum != 0) {
            newList += newNum % 2
            newNum = newNum / 2
        }

        val result = newList.toList.reverse.mkString

        return result
    }

    def main(args: Array[String]): Unit = {

        println(
            "="*48 + "\n" +
            "A simple number converter to a binary string" + "\n" +
            "="*48 + "\n"
        )

        var num: Int = readLine("Input integer here: ").toInt
        println(f"\nBinary Output: ${getBinary(num)}")
        
    }
} 

/** What's going on in this program?
 * 
 * Logically, this binary converter builds from the lowest binary digit to the highest
 * This is done by finding the modulo of the starting value which will always return 0 or 1 depending on the number is even (0) or odd (1)
 * Once the modulo of the original value is found, we can divide by 2 and then take that modulo and then divide by two until we get to 1.
 * Using 53 as an example value this process looks something like this:
 *  
 *  53 % 2 = 1
 *  53 / 2 = 26
 *  
 *  26 % 2 = 0
 *  26 / 2 = 13
 * 
 *  13 % 2 = 1
 *  13 / 2 = 6
 * 
 *  6 % 2 = 0
 *  6 / 2 = 3
 * 
 *  3 % 2 = 1
 *  3 / 2 = 1
 * 
 *  1 % 1 = 1
 * 
 * As seen above the process itself starts from the highest decimal and reduces down.
 * But what is also show is that each binary digit builds up.
 * Here are the modulos isolated:
 * 
 *  53 % 2 = 1
 *  26 % 2 = 0
 *  13 % 2 = 1
 *  6 % 2 = 0
 *  3 % 2 = 1
 *  1 % 1 = 1
 * 
 * This resulting order come out to 101011, but this is reversed.
 * Flipping the result string returns 53's true binary number 110101.
 * 
 * Programatically this is achived by first looping through the modulo and division.
 * During each loop the value is reassigned the quotent from division and the modulo is added to a ListBuffer.
 * 
 * A ListBuffer was used because it is a mutable collection unlike a standard list.
 * 
 * With the result string from the loop recorded, the ListBuffer was converted into a List.
 * This gives the appropriate data type to perform operations on.
 * 
 * The operations done were first to reverse the list to record the true binary value,
 * and then to convert that list into a string using the .mkstring function.
 * 
 * NOTE: you can convert to an Int type but in doing so would remove any 0s that come before the first instance of a 1.
 * 
 * The binary string was recorded to a result variable to be returned when the function is called.
 * 
*/


