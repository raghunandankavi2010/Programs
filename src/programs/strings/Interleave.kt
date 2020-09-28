package programs.strings

import java.lang.StringBuilder

/**
 *  Given two String a and b interleave the string to create a new String
 *  a = abc
 *  b. def
 *  output = adbecf
 *
 */

fun main() {
    val a = "ab"
    val b = "def"
    val result = interleave(a, b)
    println(result)
}

fun interleave(a: String, b: String): String {

    val sb = StringBuilder()
    (0..a.length).takeWhile {
        it < b.length
    }.forEach { index ->
        if(index < a.length) {
            sb.append(a[index])
        }
        if(index < b.length) {
            sb.append(b[index])
        }

    }
    return sb.toString()
}
