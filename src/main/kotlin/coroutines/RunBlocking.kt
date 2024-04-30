package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        delay(1000L)
        println("Hello from Coroutine!")
    }
    println("Hello from Main Thread!")
}