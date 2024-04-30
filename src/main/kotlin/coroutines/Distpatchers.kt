package coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch(Dispatchers.IO) {
            println("IO: ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Default) {
            println("Default: ${Thread.currentThread().name}")
        }
    }
}
