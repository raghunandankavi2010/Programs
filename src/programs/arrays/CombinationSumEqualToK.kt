package programs.arrays

import kotlin.collections.ArrayList

fun main() {
    val arr = intArrayOf(4, -2, 3, -1)
    val r = 2
    val n = arr.size
    val target = 2
    val output = ArrayList<List<Int>>()
    printCombination(arr, n, r, target, output)
    output.distinct().forEach {
        println(it)
    }
}

fun printCombination(arr: IntArray, n: Int, r: Int, target: Int, output: ArrayList<List<Int>>) {
    val data = IntArray(r)
    val currSum = 0
    combinationUtil(arr, data, 0, n - 1, 0, r, target, output, currSum)
}

fun combinationUtil(
    arr: IntArray, data: IntArray, start: Int,
    end: Int, index: Int, r: Int, target: Int,
    output: ArrayList<List<Int>>,
    currSum: Int

) {
    if (index == r) {
        if (currSum == target) {
            val list = ArrayList<Int>()
            listOf(data)
            data.forEach {
                list.add(it)
            }
            output.add(list)
        }
        return
    }

    var i = start
    while (i <= end) {
        var tempSum = currSum
        tempSum += arr[i]
        data[index] = arr[i]
        combinationUtil(arr, data, i + 1, end, index + 1, r, target, output, tempSum)
        i++
    }
}


