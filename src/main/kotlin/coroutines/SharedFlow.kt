package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

val sharedFlow = MutableSharedFlow<Int>()

suspend fun producer() {
    var counter = 0
    while (true) {
        delay(1000L)
        counter++
        sharedFlow.emit(counter)
    }
}

suspend fun consumer(id: Int) {
    sharedFlow.collect { value ->
        println("Consumer $id received $value")
    }
}

fun main() = runBlocking {
    val job1 = launch { producer() }
    val job2 = launch { consumer(1) }
    val job3 = launch { consumer(2) }
    delay(5000L)
    job1.cancel()
    job2.cancel()
    job3.cancel()
}