package programs.arrays

import java.util.*


/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []


Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
Accepted
1,300,908
 */

fun main() {
    val candidates = arrayOf(2,3,6,7)
    val target = 7
    val list: ArrayList<List<Int>> = ArrayList()
    Arrays.sort(candidates)
    backtrack(list, ArrayList(), candidates, target, 0)
    list.forEach { list ->
        println(list)
    }
}

private fun backtrack(
    list: ArrayList<List<Int>>,
    tempList: MutableList<Int>,
    nums: Array<Int>,
    remain: Int,
    start: Int
) {
    if (remain < 0) return else if (remain == 0) list.add(ArrayList(tempList)) else {
        for (i in start until nums.size) {
            tempList.add(nums[i])
            backtrack(list, tempList, nums, remain - nums[i], i )
            tempList.removeAt(tempList.size - 1)
        }
    }
}