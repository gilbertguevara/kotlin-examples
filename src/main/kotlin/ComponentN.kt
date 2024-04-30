class ComponentN(val list: List<Int>) {
    operator fun component1() = list.first()
    operator fun component2() = ComponentN(list.subList(1, list.size))
    operator fun component3() = "This is weird"

    override fun toString() = list.toString()
}

fun main() {
    val sd = ComponentN(listOf(1, 2, 3))
    val (head, tail, msg) = sd
    val (h, t) = sd
    val (onlyComponent1) = sd

    println(head)
    println(tail)
    println(msg)

    println(h)
    println(t)

    println(onlyComponent1)
}
