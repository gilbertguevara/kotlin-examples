fun main(args: Array<String>) {

    val a = 12
    val b = 5

    println("Enter operator either +, -, * or /")
    when (val operator = readlnOrNull()) {
        "+" -> println("$a + $b = ${a + b}")
        "-" -> println("$a - $b = ${a - b}")
        "*" -> println("$a * $b = ${a * b}")
        "/" -> println("$a / $b = ${a / b}")
        else -> println("$operator is invalid")
    }
}