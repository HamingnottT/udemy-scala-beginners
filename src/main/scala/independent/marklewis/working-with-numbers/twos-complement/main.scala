import scala.collection.mutable.ListBuffer

object TwosComplement {
    def welcomeMsg(): String = {
        return f"""${"="*48}
            |A simple app to find twos complement
            |${"="*48}""".stripMargin
    }

    def warningMsg(): String = {
        return f"""""".stripMargin  // warning message goes here
    }

    def findComplement(binString: String): String = {
        
        val binListBuffer: ListBuffer[Char] = ListBuffer()

        for (bit <- 0 to binString.length - 2 ) {
            if (binString(bit) == '0') binListBuffer += '1'
            else if (binString(bit) == '1') binListBuffer += '0'
        }

        binListBuffer += '1'

        val result = binListBuffer.mkString
        return result

    }
    
    def main (args: Array[String]): Unit = {
        println(f"""
            |${welcomeMsg()}
            |${warningMsg()}
            |""".stripMargin
        )
        
        var binaryString: String = readLine("Input binary string here: ")
        println(f"\nTwos complement of ${binaryString}: ${findComplement(binaryString)}")
    }
}
