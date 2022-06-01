// package independent.recursion.marklewis.arrays

object ArrayFunction1 {
    def fillArray(arr:Array[Int], v:Int, i:Int): Unit = {
        if(i < arr.length) {
            arr(i) = v
            fillArray(arr, v, i + 1)
        }
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(1, 1, 1, 1, 1)
        fillArray(nums, 99, 0)
        println(nums)
    }
}

/** What does this function do?
 * 
 * This function sets each value of the array by a target value v.
 * To achieve this recursion was used
*/