class Inline {
    private inline fun foo(str: String, call: (String) -> Unit) {
        call(str)
    }

    private inline fun <reified T> membersOf() = T::class.members

    fun test() {
        foo("Top level function with lambda example", ::print)
        println(membersOf<StringBuilder>().joinToString("\n"))
    }
}

fun main() {
    Inline().test()
}