import java.util.*

fun main() {
    val arr = intArrayOf(1,2,3,0,0,0,-4,-2)
    val r = 5
    val n = arr.size
    val target = 0
    val output = ArrayList<ArrayList<Int>>()
    printCombination(arr, n, r, target,output)

    output.distinct().forEach {it ->
        println(it)
    }
}

fun printCombination(arr: IntArray, n: Int, r: Int, target: Int, output: ArrayList<ArrayList<Int>>) {
    val data = IntArray(r)
    val currSum = 0
    combinationUtil(arr, data, 0, n - 1, 0, r, target, output, currSum)
}

fun combinationUtil(
    arr: IntArray, data: IntArray, start: Int,
    end: Int, index: Int, r: Int, target: Int,
    output: ArrayList<ArrayList<Int>>,
    currSum: Int

) {
    if (index == r) {
        if(currSum == target){
            val list = ArrayList<Int>()
            data.forEach{it ->
                list.add(it)
            }
            output.add(list)
        }
        return
    }

    var i = start
    while (i <= end ) {
        var tempSum = currSum
        tempSum += arr[i]
        data[index] = arr[i]
        combinationUtil(arr, data, i + 1, end, index + 1, r, target,output,tempSum)
        i++
    }
}


