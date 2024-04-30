class ElvisOperator {
    fun calculateLength(word: String?): Int {
        return word?.length ?: -1
    }
}

fun main() {
    val elvisOperator = ElvisOperator()
    var word: String? = "Elvis"
    println("$word has length ${elvisOperator.calculateLength(word)}")

    word = null
    println("$word has length ${elvisOperator.calculateLength(word)}")
}