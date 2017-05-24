package lmller.github.io.gofkotlin.builder

class Car() {
    var color: String = "red"
    var doors = 3

    override fun toString() = "$color car with $doors doors"
}

fun main(args: Array<String>) {
    Car().apply {
        color = "yellow"
        doors = 5
    }.let { println(it) }
}