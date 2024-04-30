class HigherOrderFunctions {
    fun test() {
        val string = """
    One-one was a race horse.
    Two-two was one too.
    One-one won one race.
    Two-two won one too. 
""".trimIndent()

        val result = string
            .split(" ", "-", ".", System.lineSeparator())
            .filter { it.isNotEmpty() }
            .map { it.lowercase() }
            .groupingBy { it }
            .eachCount()
            .toList()
            .sortedBy { (_, count) -> count }
            .reversed()

        println(result)
    }
}

fun main() {
    HigherOrderFunctions().test()
}