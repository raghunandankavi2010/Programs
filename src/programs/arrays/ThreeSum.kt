package programs.arrays

import java.util.*

fun main() {

    val nums = arrayOf(-1, 0, 1, 2, -1, -4)
    val k = 0
    val list = mutableListOf<Triple<Int,Int,Int>>()

    Arrays.sort(nums)
    for (i in nums.indices) {
        if(i > 0 && nums[i] == nums[i-1]) continue // very important to skip duplciates
        val firstNumber = nums[i]
        val target = 0 - nums[i]
        var left = i + 1
        var right = nums.size - 1

        while (left < right) {
            val sum = nums[left] + nums[right]
            if (sum > target){
                right --
            } else if( sum < target) {
                left ++
            } else {
                list.add(Triple(firstNumber,nums[left],nums[right]))
                // very important to skip duplicates
                while(nums[left] == nums[left + 1])
                    left++

                while(nums[right] == nums[right-1])
                    right--

                left++
                right--
            }
        }
    }

    list.forEach {
         println("${it.first} ${it.second} ${it.third}")

    }
}