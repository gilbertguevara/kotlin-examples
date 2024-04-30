package coroutines

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

class CoroutineTimeouts {
    suspend fun doSomething() {
        delay(3000L) // simulate a long-running task
        println("Something done!!")
    }

    fun test() = runBlocking {
        try {
            withTimeout(2000L) {
                doSomething()
            }
        } catch (e: TimeoutCancellationException) {
            println("The task exceeded the timeout limit.")
        }
    }
}

fun main() = run {
    CoroutineTimeouts().test()
}