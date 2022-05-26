import scala.collection.mutable.ListBuffer

object BinToDecV1 {
    def welcomeMsg(): String = {
        return f"""${"="*48}
            |A simple number converter from binary to decimal
            |${"="*48}""".stripMargin
    }

    def warningMsg(): String = {
        return f"""* NOTE: this program only supports 8-bit binary numbers up to 255
                  |* Example: 11101011""".stripMargin
    }

    def getDecimal(binString: String): Int = {     // return type needs to be ': Int = '

        val binListReversed: List[Char] = binString.toList.reverse
        val binMultiples = List(2, 4, 8, 16, 32, 64, 128, 256)
        var newListBuffer: ListBuffer[Int] = ListBuffer()
        var counter: Int = 0

        for (bit <- binListReversed) {
            newListBuffer += (bit.asDigit) * binMultiples(counter)
            counter += 1
        }

        val newList = newListBuffer.toList
        val result = newList.sum / 2

        return result
    }

    def main(args: Array[String]): Unit = {

        println(f"""
            |${welcomeMsg()}
            |${warningMsg()}
            |""".stripMargin
        )

        var binaryString: String = readLine("Input binary string here: ")
        println(f"\nBinary Output: ${getDecimal(binaryString)}")

        // getDecimal(binaryString)
        
    }
}

/** What is going on in this program?
 * 
 * Logically, it converts an inputed binary number to decimal form. This is done similar to the decimal-to-binary program but in reverse fashion
 * 
 * NOTE: for now it only supports 8-bit binary numbers up to 255
 * 
 * This is done by reversing the order of the binary string. 8-bit positions are also recorded and stored in a list.
 * A list buffer was created to store the logical operation done during conversion.
 * The binary string was also converted into a list format to be able to be iterated through successfully
 * 
 * Using a counter and a for loop, each element of the reversed binary list is iterated through.
 * While this is happening, the list buffer is being appended to for each iterated element.
 * 
 * The value stored in the list buffer is the bit value (1 or 0) of the reversed binary list times the respective bit value (2 to 256)
 * This is done by using the counter variable to curse through each index of the list storing the bit values 2 to 256
 * Multiplying each position by 0 or 1 will reflect in the resulting sum of the list
 * 
 * NOTE: Interestingly for this version each binary digit had to be subtracted by 48 (to preserve the 0 or 1) value before multiplying
 * EDIT: after further research, Char to Int conversion in Scala returns the ASCII integer value of the char value
 *  - In this case 48 for '0' and 49 for '1', to remedy this, use <char>.asDigit method to convert to a number character to its digital value
 *  - Or in a pinch subtract '0' by the char value
 * 
 * Once, all values are stored in the list buffer, the list buffer is converted to a list and then summed together.
 * 
 * Because the raw value exceeds 256 or 8-bit, the summation needed to be reduced in some way to its proper result value.
 * It was found that the sum was approximately double the true result
 * The sum was divided by 2 resulting in the true resulting decimal number
 * 
*/