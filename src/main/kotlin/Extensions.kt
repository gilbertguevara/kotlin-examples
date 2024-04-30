import kotlin.random.Random
import kotlin.random.nextInt

fun <T> retry(times: Int, interval: Long, fn: () -> T?): T? {
    return try {
        fn()
    } catch (t: Throwable) {
        if (times == 0) {
            throw t
        }
        println("Retry attempt: $times. Sleeping $interval ms")
        Thread.sleep(interval)
        retry(times - 1, interval, fn)
    }
}

/**
 * Logger Util
 */
//inline fun <reified R : Any> R.logger(): Logger =
//    LoggerFactory.getLogger(this::class.java.name.substringBefore("\$Companion"))

private const val EQUAL = "="

fun String.toDashedCase(): String {
    var result = ""

    val c: Char = this[0]
    result += Character.toLowerCase(c)

    for (i in 1..<this.length) {
        val ch: Char = this[i]

        result += if (Character.isSpaceChar(ch)) {
            '_'
        } else {
            Character.toLowerCase(ch)
        }
    }
    return result
}

/**
 * Get the query params
 */
fun String.getQueryParams(): Map<String, String> = this.split("?", "&")
    .filter { it.contains(EQUAL) }.associate {
        val (key, value) = it.split(EQUAL)
        key to value
    }

fun testRetry(): Int = 5 / Random.nextInt(0..1)

fun main() {
    val number = retry(10, 500, ::testRetry)
    println(number)

    println("Test String".toDashedCase())
    println("https://www.example.com?param1=value1&param2=value2&param3=value".getQueryParams())
}