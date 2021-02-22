package programs.strings

/**
 * Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
"cats and dog",
"cat sand dog"
]
 */

val map = HashMap<String,List<String>>()
fun main() {
    val inputString = "catsanddog"
    val wordDict = listOf<String>("cat", "cats", "and", "sand", "dog")

    wordBreak(inputString, wordDict)?.forEach {
        println(it)
    }
}

fun wordBreak(inputString: String, wordDict: List<String>): List<String>? {
    if(map.containsKey(inputString))
        return map[inputString]

    val result = ArrayList<String>()

    if(wordDict.contains(inputString)){
        result.add(inputString)
    }

    for(i in 1 until inputString.length) {
        val left = inputString.substring(0,i)
        if(wordDict.contains(left)) {
            val list = wordBreak(inputString.substring(i),wordDict)
            list?.forEach {
                result.add("$left $it")
            }
        }
    }
    map[inputString] = result
    return result

}
