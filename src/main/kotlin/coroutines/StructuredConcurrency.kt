package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        delay(1000L)
        println("Task from runBlocking")
    }

    coroutineScope {
        launch {
            delay(2000L)
            println("Task from nested launch")
        }

        delay(500L)
        println("Task from coroutine scope")
    }

    println("Coroutine scope is over")
}