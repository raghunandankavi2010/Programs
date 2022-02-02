package programs.strings

fun main() {
    generateParenthesis(3).forEach{
        println(it)
    }
}

fun generateParenthesis(n: Int): List<String> {
    val res: MutableSet<String> = HashSet<String>()
    generateParenthesis("", res, n, n)
    return ArrayList(res)
}

fun generateParenthesis(psf: String, res: MutableSet<String>, openCount: Int, closeCount: Int) {
    // Handle invalid(when closing count greater than opening) and base case.
    if (closeCount < openCount || openCount < 0) return
    if (psf.isNotEmpty() && openCount == 0 && closeCount == 0) {
        res.add(psf)
        return
    }
    // recursive call with current string value "psf".
    generateParenthesis("$psf(", res, openCount - 1, closeCount)
    generateParenthesis("$psf)", res, openCount, closeCount - 1)
}