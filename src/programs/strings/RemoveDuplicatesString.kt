package programs.strings


fun main() {
    uncommonChars()
    println()
    removeDuplicates()
}

fun removeDuplicates(){
    val input = "aabbc"
    val mod = IntArray(256)
    val sb = StringBuilder()
    input.forEachIndexed { index, c ->
        mod[input[index] - 'a'] = mod[input[index] - 'a'] + 1
        if(mod[input[index] - 'a'] == 1){
            sb.append(c)
        }

    }

    println(sb.toString())
}
fun uncommonChars(){
    val input = "characters"
    val input2 = "alphabets"
    val mod = IntArray(26)
    for (element in input) {
        mod[element - 'a'] = 1
    }
    for (i in input2.indices) {
        var value = mod[input2[i] - 'a']
        value = if (value == 1 || value == -1) {
            -1
        } else {
            1
        }
        mod[input2[i] - 'a'] = value
    }
    for (i in mod.indices) {
        if (mod[i] == 1) {
            print((i + 'a'.toInt()).toChar() + " ")
        }
    }
}
