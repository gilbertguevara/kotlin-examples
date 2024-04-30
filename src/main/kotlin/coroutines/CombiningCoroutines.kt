package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

class CombiningCoroutines {
    suspend fun performRequest(request: Int): String {
        delay(1000L)
        return "response $request"
    }

    fun test() = runBlocking {
        val nums = (1..5).asFlow()
        val strs = nums.map { performRequest(it) }
        nums.zip(strs) { a, b -> "$a -> $b" }
            .collect { println(it) }
    }
}

fun main() = run {
    CombiningCoroutines().test()
}

