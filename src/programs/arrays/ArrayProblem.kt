package programs.arrays


class ArrayProblem {

    fun method1(inputArray: Array<Int>): Array<Int> {

        var count = 0
        // put all non zero elements to the start of array
        for (i in inputArray.indices) {
            if (inputArray[i] != 0) {
                inputArray[count] = inputArray[i]
                count++
            }
        }

        // from the first zero element to end of array
        // put zeros.
        while (count < inputArray.size)
            inputArray[count++] = 0
       return inputArray
    }

    fun method2(A: Array<Int>): Array<Int> {
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

        return A
    }
}


