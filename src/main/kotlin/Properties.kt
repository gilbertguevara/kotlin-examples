class Properties {
    open class OpenBase(open val value: Int) {
        override fun toString(): String = "$value"
    }

    interface AnotherExample {
        val anotherValue: OpenBase
    }

    open class OpenChild(value: Int) : OpenBase(value), AnotherExample {
        override var value: Int = 1000
        get() = field - 7
        override val anotherValue: OpenBase = OpenBase(value)
    }

    open class AnotherChild(value: Int) : OpenChild(value) {
        final override var value: Int = value
        get() = super.value // default get() is used otherwise
        set(value) { field = value * 2 }
        final override val anotherValue: OpenChild = OpenChild(value) // Notice that we use OpenChild here, not OpenBase
    }
}

fun main() {
    val openChild = Properties.OpenChild(10)
    val anotherChild = Properties.AnotherChild(5)

    println(openChild.value)
    println(openChild.anotherValue)

    println(anotherChild.value)
    println(anotherChild.anotherValue)

    anotherChild.value = 100
    println(anotherChild.value)
    println(anotherChild.anotherValue)
}