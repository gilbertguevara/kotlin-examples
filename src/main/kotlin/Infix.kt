class Infix {
    data class Person(val name: String, val surname: String)

    infix fun String.with(other: String) = Person(this, other)

    fun test() {
        val realHero = "Juan" with "Valdez"
        val (real, bean) = realHero

        println(real)
        println(bean)
    }
}

fun main() {
    Infix().test()
}