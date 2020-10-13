package programs.arrays

import java.util.*
import kotlin.collections.ArrayList

/**
 *  given [1,2,3] array
 *  print all permutations of this array
 */

fun main() {
    val numbs = intArrayOf(1, 2, 3,4)
    // Iteratively
    /*val listOfLists = permute(numbs)
    for (list in listOfLists) {
        for (num in list) {
            print(num)
        }
        println("")
    }*/

    // Recursively
    recursivePermutation(numbs)

}

fun recursivePermutation(nums: IntArray) {

    permutation(nums, 0, nums.size - 1)

}

fun permutation(nums: IntArray, start: Int, end: Int) {
    if (start == end) {
        printArray(nums)
    } else {
        for (i in start..end) {
            swap(nums, start, i)
            permutation(nums, start + 1, end)
            swap(nums, start, i)
        }
    }
}

fun swap(arr: IntArray, x: Int, y: Int) {
    val temp = arr[x]
    arr[x] = arr[y]
    arr[y] = temp
}


fun printArray(nums: IntArray) {

    nums.forEach {
        print(it)
    }
    println("")
}

fun permute(numbs: IntArray): LinkedList<List<Int>> {

    val result = LinkedList<List<Int>>()
    var rSize: Int
    result.add(ArrayList())

    for (num in numbs) {
        rSize = result.size
        while (rSize > 0) {
            val permutation = result.pollFirst()

            for (i in 0..permutation.size) {
                val newPermutation = ArrayList<Int>(permutation)
                newPermutation.add(i, num)
                result.add(newPermutation)
            }

            rSize--
        }
    }

    return result
}
