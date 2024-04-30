class IfExpression {
    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    fun maxOf2(a: Int, b: Int): Int {
        return if (a > b) {
            a
        } else {
            b
        }
    }

    fun maxOf3(a: Int, b: Int) =
        if (a > b) {
            a
        } else {
            b
        }


    fun maxOf4(a: Int, b: Int) = if (a > b) a else b
}