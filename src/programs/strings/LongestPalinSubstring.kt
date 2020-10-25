package programs.strings

import kotlin.math.max

/**
 * Source : https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
 */
object LongestPalinSubstring {

    private fun longestPalSubstr(str: String): String {
        var maxLength = 1
        var start = 0
        val len = str.length
        // check if length of string is less than opr equal to 1
        if (len <= 1) {
            return str
        }
        var low: Int
        var high: Int
        for (i in 1 until len) {
            // Find the longest even length palindrome with
            // center points as i-1 and i for even length
            low = i - 1
            high = i
            while (low >= 0 && high < len && str[low] == str[high]) {
                if (high - low + 1 > maxLength) {
                    start = low
                    maxLength = high - low + 1
                }
                --low
                ++high
            }

            // Find the longest odd length palindrome with
            // center point as i for odd length
            low = i - 1
            high = i + 1
            while (low >= 0 && high < len && str[low] == str[high]) {
                if (high - low + 1 > maxLength) {
                    start = low
                    maxLength = high - low + 1
                }
                --low
                ++high
            }
        }
        return str.substring(start,start+ maxLength)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val str = "baabcd"
        val result = findPalindrome(str)
        println(result)
        //println("Paldindrome Substring: " + longestPalSubstr(str));
    }

    private fun findPalindrome(str: String): String {
        if (isPalindrome(str)) {
            return str
        } else {
            for (len in str.length downTo 1) {
                var i = 0
                while (i + len <= str.length) {
                    if (isPalindrome(str.substring(i, i + len))) {
                        return str.substring(i, i + len)
                    }
                    i++
                }
            }
        }
        return ""
    }

    private fun isPalindrome(str: String): Boolean {
        var low = 0
        var high = str.length - 1
        while (low <= high && str[low] == str[high]) {
            low++
            high--
        }
        return low >= high
    }
}