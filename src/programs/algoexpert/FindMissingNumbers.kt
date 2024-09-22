package programs.algoexpert

fun main() {

    val arr = mutableListOf(4, 5, 1, 3)
    val result = missingNumbers(arr)
    result.forEach {
        println(it)
    }
}

fun missingNumbers(nums: MutableList<Int>): List<Int> {
   val set = HashSet<Int>()
    for( i in 1.. nums.size+2) {
        set.add(i)
    }
    nums.forEach {
        set.remove(it)
    }

    return set.toMutableList()
}
