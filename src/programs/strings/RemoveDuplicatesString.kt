package programs.strings


fun main() {
    val input1 = "characters"
    val input2 = "alphabets"
    uncommonChars(input1,input2)
    println()
    val input = "aabbc"
    removeDuplicates(input)
}

fun removeDuplicates(input: String){
    val mod = IntArray(256)
    val sb = StringBuilder()
    input.forEachIndexed { index, c ->
        mod[input[index] - 'a'] = mod[input[index] - 'a'] + 1
        if(mod[input[index] - 'a'] == 1) {
            sb.append(c)
        }
    }

    println(sb.toString())
}
fun uncommonChars(input1: String, input2: String){
    val mod = IntArray(26)
    for (element in input1) {
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
