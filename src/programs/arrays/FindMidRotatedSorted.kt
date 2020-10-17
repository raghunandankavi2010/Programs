package programs.arrays

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
 */

fun main() {
    val nums = intArrayOf(4,5,6,7,0,1,2)
    println(findMin(nums))
    println("Using standard functions available")
    val min = nums.minOrNull()
    println(min)
}

fun findMin(nums: IntArray): Int {
    var l = 0
    var r =  nums.size - 1

    while(l < r){
        val mid = l+(r-l)/2

        when {
            nums[mid]>nums[r] -> {
                l = mid+1
            }
            nums[mid]<nums[r] -> {
                r = mid
            }
            else -> {
                r--
            }
        }
    }
    return nums[l]
}
