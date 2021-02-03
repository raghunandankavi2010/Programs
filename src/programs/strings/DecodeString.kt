package programs.strings

/**
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 */

fun main() {
    val digits = charArrayOf('1', '1', '1')
    println(countDecodingDP(digits,3))
}

fun countDecodingDP(digits: CharArray, n: Int): Int {
    val count = IntArray(n + 1)
    count[0] = 1
    count[1] = 1
    if (digits[0] == '0') //for base condition "01123" should return 0
        return 0
    for (i in 2..n) {
        count[i] = 0

        // If the last digit is not 0,
        // then last digit must add to
        // the number of words
        if (digits[i - 1] > '0') count[i] = count[i - 1]

        // If second last digit is smaller
        // than 2 and last digit is smaller
        // than 7, then last two digits
        // form a valid character
        if (digits[i - 2] == '1' ||
            digits[i - 2] == '2' &&
            digits[i - 1] < '7'
        ) count[i] += count[i - 2]
    }
    return count[n]
}
