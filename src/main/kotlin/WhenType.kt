class WhenType {
    fun whenType(x: Any) {
        when (x) {
            is Int -> println(x + 1)
            is String -> println(x.length + 1)
            is IntArray -> println(x.sum())
        }
    }
}

fun main() {
    val obj = WhenType()
    obj.whenType(1)
    obj.whenType("Hello, World!")
    obj.whenType(listOf(1, 2, 3).toIntArray())
}