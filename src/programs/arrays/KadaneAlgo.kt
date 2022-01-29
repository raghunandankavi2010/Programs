package programs.arrays

fun main() {
    val array = arrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)

    var currSum = 0
    var maxSum = 0
    array.forEach {
        currSum += it

        if(currSum > maxSum) {
            maxSum = currSum
        }

        if(currSum < 0) {
            currSum = 0
        }
    }

    println(maxSum)
}