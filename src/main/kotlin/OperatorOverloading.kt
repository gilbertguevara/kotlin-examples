import java.time.LocalDate

class OperatorOverloading {
    class Point(val x: Int, val y: Int) {
        operator fun plus(other: Point) = Point(x + other.x, y + other.y)

        operator fun minus(other: Point) = Point(x - other.x, y - other.y)

        operator fun times(other: Point) = Point(x * other.x, y * other.y)

        operator fun times(factor: Int): Point = Point(x * factor, y * factor)

        operator fun div(other: Point) = Point(x / other.x, y / other.y)

        operator fun unaryMinus() = Point(-x, -y)

        operator fun inc() = Point(x + 1, y + 1)

        operator fun dec() = Point(x - 1, y - 1)

        operator fun not() = Point(y, x)

        operator fun rem(other: Point): Point = Point(x % other.x, y % other.y)

        override fun toString(): String = "($x, $y)"
    }


    class Shape {
        private val points = mutableListOf<Point>()

        operator fun Point.unaryPlus() {
            points.add(this)
        }

        override fun toString() = points.joinToString(" ")
    }

    fun shape(init: Shape.() -> Unit): Shape {
        val shape = Shape()
        shape.init()

        return shape
    }

    interface Page<T> {
        fun pageNumber(): Int
        fun pageSize(): Int
        fun elements(): MutableList<T>
    }
}

fun main() {
    println("Shape")
    val s = OperatorOverloading().shape {
        +OperatorOverloading.Point(0, 0)
        +OperatorOverloading.Point(1, 1)
        +OperatorOverloading.Point(2, 2)
        +OperatorOverloading.Point(3, 4)
    }
    println(s)

    println("Plus")
    var p1 = OperatorOverloading.Point(0, 1)
    var p2 = OperatorOverloading.Point(1, 2)
    println(p1 + p2)

    println("Unary minus")
    var p = OperatorOverloading.Point(4, 2)
    println(-p)

    println("Increment")
    p = OperatorOverloading.Point(4, 2)
    println(p++)
    println(p)
    println(++p)

    println("Decrement")
    println(p--)
    println(p)
    println(--p)

    println("Not")
    println(!p)

    p1 = OperatorOverloading.Point(2, 4)
    p2 = OperatorOverloading.Point(1, 4)
    println("Minus, multiply, divide, times")
    println(p1 - p2)
    println(p1 * p2)
    println(p1 / p2)
    p1 = OperatorOverloading.Point(1, 2)
    println(p1 * 2)

    println("Compound assignments")
    var point = OperatorOverloading.Point(0, 0)
    point += OperatorOverloading.Point(2, 2)
    point -= OperatorOverloading.Point(1, 1)
    point *= OperatorOverloading.Point(2, 2)
    point /= OperatorOverloading.Point(1, 1)
    point /= OperatorOverloading.Point(2, 2)
    point *= 2
    println(point)

    val colors = mutableListOf("red", "blue")
    colors += "green"
    println(colors)

//    BigInteger.ONE > BigInteger.ZERO
    println("red" in colors)
}