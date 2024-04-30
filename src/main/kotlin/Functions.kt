class Functions {

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun mul(a: Int, b: Int) = a * b

    fun printMul(a: Int, b: Int): Unit {
        println(mul(a, b))
    }

    fun printMul1(a: Int = 1, b: Int) {
        println(mul(a, b))
    }

    fun printMul2(a: Int, b: Int = 1) = println(mul(a, b))

}