// package independent.recursion.marklewis.arrays

// Veratile function to recursively perform actions on a given array

object ArrayFunction2 {
    def operateOnArray(arr:Array[Int], i:Int, f: (Int, Int) => Int): Int = {
            if(i < arr.length-1) {
                f(arr(i), operateOnArray(arr, i+1, f))
            } else {
                arr(i)
            }
        }

    def main(args: Array[String]): Unit = {
        val nums2 = Array(1, 2, 3, 4, 5, 6)
        println(operateOnArray(nums2, 0, _+_))
        println(operateOnArray(nums2, 0, _-_))
        println(operateOnArray(nums2, 0, _*_))
    }
}

/** What's going on in this function?
 * 
 * There are 3 inputs
 * - input array
 * - the index number to start at
 * - and an anonymous function that can take two integer inputs and output a single integer output
 * 
 * This function recursively goes through each item of the array and performs the anonymous function (specified by the user)
 * The base case is if i equals the length - 1 of the array
 * to reach this, each recursion adds plus 1 to the index input
 * 
 * Result 1 adds the next index with to the previous index
 * Result 2 subtracts the next index by the previous index
 * Result 3 multiplies the previous index by the next index (factorial function)
 */
