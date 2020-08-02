package programs.strings

/**
 *  Longest common subsequence.
 */

fun main() {
    val str1 = "ABCDGHLQR"
    val str2 = "AEDPHR"

    val result: Int = lcsDynamic(str1.toCharArray(), str2.toCharArray())
    print(result)
}

fun lcsDynamic(str1: CharArray, str2: CharArray): Int {
    val temp = Array(str1.size + 1) { IntArray(str2.size + 1) }
    var max = 0
    for (i in 1 until temp.size) {
        for (j in 1 until temp[i].size) {
            if (str1[i - 1] == str2[j - 1]) {
                temp[i][j] = temp[i - 1][j - 1] + 1
            } else {
                temp[i][j] = kotlin.math.max(temp[i][j - 1], temp[i - 1][j])
            }
            if (temp[i][j] > max) {
                max = temp[i][j]
            }
        }
    }
    return max
}
