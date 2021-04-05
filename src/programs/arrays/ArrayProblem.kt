package programs.others


fun main() {
    val inputArray = arrayOf(1,0,7,8,0,0,2,3,4,0,0,9)

    /*method1(inputArray)
    inputArray.forEach {
        print("$it ")
    }*/

    method2(inputArray)
    inputArray.forEach {
        print("$it ")
    }
}

fun method1(inputArray: Array<Int>) {

    var count = 0
    // put all non zero elements to the start of array
    for(i in inputArray.indices) {
        if (inputArray[i] != 0 ) {
            inputArray[count] = inputArray[i]
            count++
        }
    }

    // from the first zero element to end of array
    // put zeros.
    while (count < inputArray.size)
        inputArray[count++] = 0

}

fun method2(A: Array<Int>) {
    var j = 0

    // each time we encounter a non-zero, `j` is incremented, and
    // swap i and j
    for (i in A.indices) {
        if (A[i] != 0) {
            val temp = A[i]
            A[i] = A[j]
            A[j] = temp
            j++
        }
    }
}
