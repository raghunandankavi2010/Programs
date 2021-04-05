package programs.others


fun main() {

    val inputArray = arrayOf(1,0,7,8,0,0,2,3,4,0,0,9)
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

    inputArray.forEach {
        print("$it ")
    }

}