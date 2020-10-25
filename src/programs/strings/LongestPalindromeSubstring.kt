package programs.strings


/**
 * Longest palindrome substring in o(n2)
 */
object LongestPalindromeSubstring {

    private fun longestPalindrome(str: String): String {
        var lps = ""
        val len = str.length
        // check if length of string is less than opr equal to 1
        if (len <= 1) {
            return str
        }

        for (i in str.indices) {
            val odd = expandPalindrome(str, i, i)
            val even = expandPalindrome(str, i, i + 1)
            if (lps.length < odd.length) {
                lps = odd
            }
            if (lps.length < even.length) {
                lps = even
            }

        }
        return lps
    }

    private fun expandPalindrome(str: String, l: Int, r: Int): String {
        var low = l
        var high = r
        while (low >= 0 && high < str.length && str[low] == str[high]) {
            low--
            high++
        }
        return str.substring(low + 1, high)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val str = "baabcd"
        println("Brute force approach")
        val result = findPalindrome(str)
        println(result)
        println("Better approach")
        println(longestPalindrome(str))
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