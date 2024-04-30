package cache

import com.github.javafaker.Faker

class TestMemoize {
    private val cache = ExpirableCache<String, List<Pair<String, Int>>>(PerpetualCache(), 60000L)

    private fun countWords(string: String): List<Pair<String, Int>> {
        println("Real call at ${System.nanoTime()}")

        return string
            .split(" ", "-", ".", System.lineSeparator())
            .filter { it.isNotEmpty() }
            .map { it.lowercase() }
            .groupingBy { it }
            .eachCount()
            .toList()
            .sortedBy { (_, count) -> count }
            .reversed()
    }

    fun test(string: String) {
        var memoizedCall = ::countWords.memoize(cache, "temp")
        println(memoizedCall(string))
    }
}

fun main() {
    val testMemoize = TestMemoize()
    val faker = Faker()

    repeat(20) {
        var fact = faker.chuckNorris().fact()
        println(fact)
        testMemoize.test(fact)
        Thread.sleep(1000)
        println()
    }
}