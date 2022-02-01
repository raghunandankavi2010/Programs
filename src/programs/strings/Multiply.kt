package programs.strings

fun main() {
    val num1 = "123"
    val num2 = "456"
    println(multiply(num1,num2))
}
fun multiply(num1: String, num2: String): String {

    val char1 = num1.toCharArray()
    val char2 = num2.toCharArray()
    var mul: Int = 1
    val res = Array(num1.length + num2.length) { 0 }


    for(i in char1.size-1 downTo  0) {

        for(j in char2.size-1 downTo 0){
            val n1 = (char1[i] - '0')
            val n2 = (char2[j] - '0')
            mul = n1 * n2
            val sum = res[ i + j + 1] + mul // prev sum at position + product
            res[ i + j ] += sum /10 // add carry to prev position
            res[ i + j + 1 ] = sum %10 // add last digit to array

        }
    }

    val stringBuilder = StringBuilder()
    res.forEach {
        if(it != 0 || stringBuilder.isNotEmpty()) {
            stringBuilder.append(it)
        }
    }
    return stringBuilder.toString()
}
