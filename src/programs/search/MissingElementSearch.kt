package programs.search

import kotlin.jvm.JvmStatic
import programs.search.MissingElementSearch

object MissingElementSearch {
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(1, 3, 4, 5)
        val x = findMissingElement(arr)
        println(x)
    }

    private fun findMissingElement(arr: IntArray): Int {
        var low = 0
        var high = arr.size - 1
        while (low <= high) {
            val middle = (low + high) / 2
            // this is the most important condition which i missed
            if (arr[middle] != middle + 1 && arr[middle - 1] == middle) {
                return middle + 1
            }
            // this is straight forward. if arr[mid] != middle+1 move left or move right
            if (arr[middle] != middle + 1) {
                high = middle - 1
            } else {
                low = middle + 1
            }
        }
        return -1
    }
}