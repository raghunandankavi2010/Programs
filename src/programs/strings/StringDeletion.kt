package programs.strings

import java.lang.StringBuilder
import java.util.*

/**
 *  Given String s1 = "ab#c"
 *  where % represents a backspace ie delete character b results in ac
 *  Similarly for String s1 = "ad#c" results is ac
 *  comparing s1 == s2 is true
 */

fun main(args: Array<String>) {

    val S = "ab#c"
    val T = "ad#c"
    val isTrue = check(S, T)
    println(isTrue)

}

fun check(s1: String, s2: String): Boolean {

    val string1 = processString(s1)
    val string2 = processString(s2)
    println("$string1 $string2")
    return string1 == string2
}

fun processString(s: String): String {
    val stack = Stack<Char>()
    val result = StringBuilder()
    val scharArray = s.toCharArray()
    var temp = ' '
    for (i in scharArray.indices) {
        if (scharArray[i] != '#') {
            temp = ' '
            stack.push(scharArray[i])
        } else if (stack.isNotEmpty() && temp != '#') {
            temp = '#'
            stack.pop()
        }
    }

    while (stack.isNotEmpty()) {
        result.insert(0,stack.pop())
    }

    return result.toString()

}
