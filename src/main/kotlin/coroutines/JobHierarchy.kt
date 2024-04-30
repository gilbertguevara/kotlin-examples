package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val parentJob = launch {
        val childJob = launch {
            while (true) {
                println("Child is running")
                delay(500L)
            }
        }
        delay(2000L)
        println("Cancelling child job")
        childJob.cancel()
    }
    parentJob.join()
}