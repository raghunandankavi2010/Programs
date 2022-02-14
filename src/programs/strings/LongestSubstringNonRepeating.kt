package programs.strings

import java.util.HashMap
import kotlin.jvm.JvmStatic
import kotlin.math.max

class LongestSubstringNonRepeating {
    /**
     *
     * @param input string
     * @return output longest length substring without repeating chars
     * https://www.baeldung.com/java-longest-substring-without-repeated-characters
     */
    private fun getUniqueCharacterSubstring(input: String): String {
        val visited: MutableMap<Char, Int> = HashMap()
        var output = ""
        var start = 0
        var end = 0
        var finalLength = 0
        while (end < input.length) {
            val currChar = input[end]
            if (visited.containsKey(currChar)) {
                start = max(visited.getOrDefault(currChar, 0) + 1, start)
            }
            if (output.length < end - start + 1) {
                output = input.substring(start, end + 1)
                output = output.trim { it <= ' ' } // remove spaces
            }
            if (finalLength < (end - start + 1)) {
                finalLength = end - start + 1
            }
            visited[currChar] = end
            end++
        }
        println(finalLength)

        return output
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val longestSubstringNonRepeating = LongestSubstringNonRepeating()
            println(longestSubstringNonRepeating.getUniqueCharacterSubstring("abcabcbb"))
        }
    }
}