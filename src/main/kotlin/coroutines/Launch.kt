package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("Hello from Coroutine!")
    }
    println("Hello from Main Thread!")
    Thread.sleep(2000L)
}