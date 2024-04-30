import shape.Shape

class ConstructorsInheritance {
    class Circle(val radius: Double, val center: Point): Shape {
        override fun area(): Double = Math.PI * radius * radius
    }

    open class Point(val x: Int, val y: Int) {
        constructor(other: Point) : this(other.x, other.y)

        constructor(circle: Circle) : this(circle.center)

        override fun toString(): String = "$x, $y"
    }

    class Color(private val code: String) {
        override fun toString(): String = code
    }

    class ColoredPoint(val color: Color, x: Int, y: Int) : Point(x, y) {
        override fun toString(): String = "$x, $y: $color"
    }
}

fun main() {
    val pointAtTen = ConstructorsInheritance.Point(10, 10)
    val circle = ConstructorsInheritance.Circle(10.0, pointAtTen)
    val point = ConstructorsInheritance.Point(pointAtTen)
    val pointFromCircle = ConstructorsInheritance.Point(circle)
    val coloredPoint = ConstructorsInheritance.ColoredPoint(ConstructorsInheritance.Color("#FFFFFF"), 5, 5)

    println(circle.radius)
    println(circle.center)
    println(pointAtTen)
    println(point)
    println(pointFromCircle)
    println(coloredPoint)
}