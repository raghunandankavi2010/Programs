package programs.others

fun main() {
    val num = intArrayOf(9, 9, 9)
    if (isAll9(num, num.size)) {
        print("1")
        for (i in 0 until num.size - 1) print("0")
        println("1")
    } else {
        getNextPalinDrome(num, num.size)
    }

}

fun isAll9(num: IntArray, n: Int): Boolean {
    for (i in 0 until n) if (num[i] != 9) return false
    return true
}

fun getNextPalinDrome(num: IntArray, size: Int) {
    val mid = num.size / 2;

    var i = mid - 1;
    var j = if (size % 2 == 0) mid else mid + 1

    while (i >= 0 && num[i] == num[j]) {
        i--
        j++
    }
    var leftsmaller = false
    if (i < 0 || num[i] < num[j])
        leftsmaller = true

    while (i >= 0) {
        num[j++] = num[i--]
    }

    if (leftsmaller) {
        var carry = 1
        if (size % 2 == 1) {
            num[mid] = num[mid] + 1
            carry = num[mid] / 10
            num[mid] = num[mid] % 10
        }

        i = mid - 1
        j = if (size % 2 == 0) mid else mid + 1

        while (i >= 0 && carry > 0) {
            num[i] = num[i] + carry
            carry = num[i] / 10
            num[i] = num[i] % 10
            num[j] = num[i]
            i--
            j++
        }
    }
    printarray(num)

}

fun printarray(num: IntArray) {
    for (i in num.indices) print(num[i])
    println()
}