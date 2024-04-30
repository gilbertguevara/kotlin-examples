class NullSafety {

    val notNullText: String = "Definitely not null"
    val nullableText1: String? = "Might be null"
    val nullableText2: String? = null

    fun funny(text: String?) {
        if (text != null)
            println(text)
        else
            println("Nothing to print :(")
    }

    fun funnier(text: String?) {
        val toPrint = text ?: "Nothing to print :("
        println(toPrint)
    }

}

fun main() {
    val nullSafety = NullSafety()

    nullSafety.funny(nullSafety.notNullText)
    nullSafety.funny(nullSafety.nullableText1)
    nullSafety.funny(nullSafety.nullableText2)

    nullSafety.funnier(nullSafety.notNullText)
    nullSafety.funnier(nullSafety.nullableText1)
    nullSafety.funnier(nullSafety.nullableText2)
}