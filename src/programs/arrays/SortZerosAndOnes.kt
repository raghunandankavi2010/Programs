package programs.arrays

/**
 * Sort array of zeros and 1
 */

fun main() {
    val array = arrayOf(1, 0, 1, 1, 0, 1, 0, 0)

    var left = 0
    var right = array.size -1
    while(left > right) {
        if(array[left] == 1) {
            val temp = array[left]
            array[left] = array[right]
            array[right] = temp
            right --
        } else {
            left ++
        }
    }
}