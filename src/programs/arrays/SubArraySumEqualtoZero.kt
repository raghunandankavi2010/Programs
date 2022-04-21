package programs.arrays


fun main() {

    val intArray = arrayOf(4,-1,2,1)
    subArraySumEqualtoZero(intArray)
    val k = 3
    subArraySumEqualToK(intArray,k)
}

fun subArraySumEqualToK(intArray: Array<Int>, k: Int) {
    var sum = 0
    var res = 0
    val hashMap = HashMap<Int, Int>()
    hashMap[0] = 1
    for (i in intArray.indices) {
        sum += intArray[i]
        if (hashMap.containsKey(sum - k)) {
            res += hashMap[sum - k]!!
        }
        hashMap[sum] = hashMap.getOrDefault(sum, 0) + 1
    }
    println(res)

}

fun subArraySumEqualtoZero(intArray: Array<Int>) {
    val hashMap = HashMap<Int,Int>()
    var flag = false
    var maxSum = 0
    var end = 0
    var start = 0

    for(i in intArray.indices) {
        maxSum += intArray[i]
        if(hashMap.containsKey(maxSum) || maxSum == 0 || intArray[i] == 0) {
            flag = true
            end = i
            start = hashMap.getOrDefault(maxSum,-1) + 1
            if(start == -1){
                start = 0
            }
            break
        } else {
            hashMap.put(maxSum,i)
        }
    }

    if(flag) {
        println("Yes $start $end")
        println("Subrray : ")

        for(i in start.. end){
            print("${intArray[i]} ")
        }
    } else {
        println("No")
    }
}

