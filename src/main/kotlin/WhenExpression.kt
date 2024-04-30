fun main(args: Array<String>) {

    val a = 12
    val b = 5

    println("Enter operator either +, -, * or /")
    val result = when (val operator = readlnOrNull()) {
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> a / b
        else -> "$operator operator is invalid operator."
    }

    println("result = $result")
}