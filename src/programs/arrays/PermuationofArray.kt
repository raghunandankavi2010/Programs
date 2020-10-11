package programs.arrays

import java.util.*
import kotlin.collections.ArrayList

/**
 *  given [1,2,3] array
 *  print all permutations of this array
 */

fun main() {
    val numbs = intArrayOf(1,2,3)
    val listOfLists = permute(numbs)

   for( list in listOfLists){
       for( num in list){
           print(num)
       }
       println("")
   }
   // println(listOfLists)

}

fun permute(numbs: IntArray) : LinkedList<List<Int>> {

    val result = LinkedList<List<Int>>()
    var rSize: Int
    result.add(ArrayList())

    for(num in numbs) {
        rSize = result.size
        while (rSize > 0) {
            val permutation = result.pollFirst()

            for (i in 0..permutation.size) {
                val newPermutation = ArrayList<Int>(permutation)
                newPermutation.add(i, num)
                result.add(newPermutation)
            }

            rSize--
        }
    }

    return result
}
