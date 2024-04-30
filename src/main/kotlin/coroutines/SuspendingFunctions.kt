package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun doSomething() {
    delay(1000L)
    println("Doing something")
}

fun main(): Unit = runBlocking {
    launch {
        doSomething()
    }
}