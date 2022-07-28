package programs.arrays

/**
 *  Minimum number of swaps to group all ones together
 */
fun main() {
    val arr = arrayOf(1,0,1,0,1,0,1,1,1)

    val totalOnes = arr.count { it == 1}
    var currZeros = 0
    var ans: Int

    for(i in 0 until totalOnes) {
        if(arr[i] == 0) {
            currZeros += 1
        }
    }
    ans = currZeros


    for(i in totalOnes until arr.size) {
        if(arr[i] == 0) {
            currZeros += 1
        }
        if (arr[i - totalOnes] == 0)
            currZeros -= 1
        ans = ans.coerceAtMost(currZeros)
    }

    println(ans)

}

