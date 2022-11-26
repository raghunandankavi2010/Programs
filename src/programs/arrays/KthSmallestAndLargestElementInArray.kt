package programs.arrays

import java.util.*

object KthSmallestAndLargestElementInArray {
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(2, 3, 15, 1, 0, 23, 21)
        val k = 2
        val kthSmallestElement = findKthSmallestElement(arr, k)
        val kthLargestElement = findKthLargestElement(arr, k)
        System.out.printf("Smallest %d element is %d%n", k, kthSmallestElement)
        System.out.printf("Largest %d element is %d%n", k, kthLargestElement)
    }

    private fun findKthSmallestElement(arr: IntArray, k: Int): Int {
        val pq = PriorityQueue(Comparator.reverseOrder<Int>())
        for (i in 0 until k) {
            pq.add(arr[i]) // 3 2
        }
        // from 1 to 21
        // arr[i] now is 1
        // remove from queue ie 15
        // 3 2
        // remove 3 from queue
        // 2 1 0
        for (i in k until arr.size) {
            if (arr[i] < pq.peek()) {
                pq.poll() // remove from queue
                pq.add(arr[i])
            }
        }
        return pq.peek() // return 2
    }

    private fun findKthLargestElement(arr: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int>()
        for (i in 0 until k) {
            pq.add(arr[i]) //2 3
        }
        // from 1 to 21
        // arr[i] now is 1
        // 1 > 2 skip
        // 0 > 2 skip
        // 3 > 23 true
        // remove 2 and add 23
        // 3 15 23
        // 21 > 3
        // remove 3 and add 21
        // 15 23 21
        // return 15
        for (i in k until arr.size) {
            if (arr[i] > pq.peek()) {
                pq.poll()
                pq.add(arr[i])
            }
        }
        return pq.peek()
    }
}