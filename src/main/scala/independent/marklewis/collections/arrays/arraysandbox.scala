// package independent.recursion.marklewis.collections.arrays

object ArraySandbox {
    
    def sandbox1(): Unit = {

        // finding the min and max of the array
        val a1 = Array(1, 3, 2, 5, 3)

        // implicit functions
        println(a1.min)
        println(a1.max)

        // explicit max
        var myList = a1         // preserves the array a1
        var max = myList(0)     // the 0 is the starting index for the for loop below

        for (i <- 1 to (myList.length - 1)) {       // for loop iterate thru each index i of the array myList until length - 1
            if (myList(i) > max) max = myList(i)    // this compares to see if current index is greater than the last; at each iteration, the value thats greater gets reassigned to 'max' until the iteration ends
        }

        println(f"Max value: ${max}")

        // explicit min
        var min = myList(0)

        for (i <- 1 to (myList.length - 1)) {
            if (myList(i) < max) max = myList(i)
        }
        println(f"Min value: ${min}")
    }

    def sandbox2(): Unit = {
        // provided by TutorialsPoint
        import Array._

        var myMatrix = ofDim[Int](3,3)
        println(myMatrix.length - 1) 
        

        // building the matrix
        for (i <- 0 to myMatrix.length - 1) {   // first dimension
            for (j <- 0 to myMatrix.length - 1) {   // second dimension
                myMatrix(i)(j) = j;
            }
        }

        // printing the matrix
        for (i <- 0 to myMatrix.length - 1) {
            for (j <- 0 to myMatrix.length - 1) {
                print(f"${myMatrix(i)(j)} ")
            }
            println()
        }
    }

    def sandbox3(): Unit = {
        import Array._          //important for various methods

        var myArray1 = Array(1.9, 2.9, 3.4, 3.5)
        var myArray2 = Array(8.9, 7.9, 0.4, 1.5)     
        
        // different array methods to use

        // concatentation
        def concatArray(): Unit = {
            
            var concatArray = concat(myArray1, myArray2)    // use the concat() method
            for (x <- concatArray) println(x)               // printing array elements from concatArray
        
        }
        
        // creating an array from range
        def arrayFromRange(): Unit = {

            var myArray1 = range(10, 20, 2)
            var myArray2 = range(10, 20, 2)

            for (ele <- myArray1) println(f"${ele}")
            for (ele <- myArray2) println(f"${ele}")

        }

        // using fill
        def fillMethodTest1(): Unit = {

            var fillTest1 = fill(2)(myArray1(0))    // creates an array with 2 elements with the first value of Array1
            for (i <- fillTest1) println(i)
        
        }

        
        // function calls
        concatArray()
        println("-"*24)
        arrayFromRange()
        println("-"*24)
        fillMethodTest1()
    }

    def main(args: Array[String]): Unit = {
        println("="*48)
        sandbox1()  // Min and Max
        println("-"*48)
        sandbox2()  // Matrices
        println("-"*48)
        sandbox3()  // Other methods
    }
}