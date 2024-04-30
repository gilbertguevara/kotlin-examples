fun main() {
    val items = listOf("apple", "banana", "kiwifruit")

    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

    var toComplete: Boolean
    var index1 = 0
    do {
        toComplete = index1 < items.size - 1
        println("item at $index1 is ${items[index1]}")
        index1++
    } while(toComplete)
}