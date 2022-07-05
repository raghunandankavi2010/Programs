package programs.arrays

import kotlin.math.abs


/**
 * Two pointer technique problems
 * Given array  -6,-2,-1,1,4,6
 * Output = 1,1,4,16,36,36
 * Given array1  -6,-2,-1,1,4,6
 * Given array2 - 4,16,36
 * Output = -6 -2 -1 1 4 16 36 46
 */

fun main() {
    println("Merge two sorted Array")
    mergeArray()
    println("\nSquare and sort a sorted array")
    squareSort()
}

fun mergeArray() {
    val inputArray1 = arrayOf(1)
    val inputArray2 = arrayOf(1,1,2)

    var p1 = inputArray1.size - 1
    var p2 = inputArray2.size - 1
    val outputArray = IntArray(inputArray1.size + inputArray2.size) { 0 }

    var n = outputArray.size - 1


    while (p1 >= 0 && p2 >= 0) {
        if (inputArray1[p1] == 0) {
            p1--
        } else if (inputArray2[p2] == 0) {
            p2--
        }
        if (inputArray1[p1] >= inputArray2[p2]) {
            outputArray[n] = inputArray1[p1]
            p1--
        } else if(inputArray1[p1] < inputArray2[p2]){
            outputArray[n] = inputArray2[p2]
            p2--
        }
        n--
    }


    while (n >= 0 && p1 >= 0) {
        outputArray[n] = inputArray1[p1]
        p1--
        n--
    }

    while (n >= 0 && p2 >= 0) {
        outputArray[n] = inputArray2[p2]
        p2--
        n--
    }

    val resultArray = outputArray.filter { it -> it != 0 }.toIntArray()

    resultArray.forEach { num ->
        print("$num ")
    }
}

fun squareSort() {
    val inputArray = arrayOf(-6, -2, -1, 1, 4, 6)
    val outputArray = IntArray(inputArray.size) { 0 }

    var right = inputArray.size - 1
    var left = 0
    var n = inputArray.size - 1

    while (n >= 0) {
        if (abs(inputArray[left]) > inputArray[right]) {
            outputArray[n] = inputArray[left] * inputArray[left]
            left++
        } else {
            outputArray[n] = inputArray[right] * inputArray[right]
            right--
        }
        n--
    }

    outputArray.forEach { num ->
        print("$num ")
    }
}