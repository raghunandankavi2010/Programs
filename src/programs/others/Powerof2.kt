package programs.others


fun main() {
    val n = 28
    println(findPowerOfTwo(n))
}

fun findPowerOfTwo(number: Int): Boolean {
    var n = number
    if (n == 0)
        return false

    while (n != 1) {
        if (n % 2 != 0)
            return false
        n /= 2
    }
    return true

}
