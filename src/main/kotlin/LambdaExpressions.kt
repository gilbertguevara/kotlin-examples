fun main() {
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    val mul = { x: Int, y: Int -> x * y }

    println(sum(3, 4))
    println(mul(3, 4))

    val items = listOf(1, 2, 3, 4, 5)
    val badProduct = items.fold(1, { acc, e -> acc * e })
    val goodProduct = items.fold(1) { acc, e -> acc * e }

    println(badProduct)
    println(goodProduct)

    run({ println("Not Cool") })
    run { println("Very Cool") }

}