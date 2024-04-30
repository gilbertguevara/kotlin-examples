class InitBlocks {
    class Example(val value: Int, info: String) {
        val anotherValue: Int
        private var info = "Description: $info"

        init {
            this.info += ", with value $value"
        }

        val thirdValue = computeAnotherValue() * 2

        private fun computeAnotherValue() = value * 10

        init {
            anotherValue = computeAnotherValue()
        }

        override fun toString(): String = info
    }
}

fun main() {
    val example = InitBlocks.Example(10, "Some info")
    println(example.value)
    println(example.anotherValue)
    println(example.thirdValue)

    println(example)
}