package lmller.github.io.gofkotlin.visitor

sealed class Shape()
class Square(val side: Double) : Shape()
class Circle(val radius: Double) : Shape()
class Rectangle(val width: Double, val height: Double) : Shape()


fun main(args: Array<String>) {
    val figures = listOf(Circle(4.0), Square(5.0), Rectangle(6.0, 7.0))

    val perimeterVisitor = { shape: Shape ->
        when (shape) {
            is Rectangle -> 2 * shape.height + 2 * shape.width
            is Circle -> 2 * Math.PI * shape.radius
            is Square -> 4 * shape.side
        }
    }

    val areaVisitor = { shape: Shape ->
        when (shape) {
            is Rectangle -> shape.height * shape.width
            is Circle -> shape.radius.square() * Math.PI
            is Square -> shape.side.square()
        }
    }

    val totalArea = figures.sumByDouble { areaVisitor(it) }
    println("Total area = $totalArea")

    val totalPerimeter = figures.sumByDouble { perimeterVisitor(it) }
    println("Total perimeter = $totalPerimeter")
}

fun Double.square() = this * this