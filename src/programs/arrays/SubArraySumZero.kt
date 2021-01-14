package programs.arrays

fun main() {

    val array = intArrayOf(-3, 2, 3, 1, 6)
    val isSubArrayZero = findSubArrayZero(array)
    println(isSubArrayZero)
}

fun findSubArrayZero(array: IntArray): Boolean {

    val set = HashSet<Int>()
    var sum = 0
    array.forEach {
        sum += it
        if (it == 0 || sum == 0 || set.contains(sum))
            return true
        set.add(sum)
    }
    return false
}
