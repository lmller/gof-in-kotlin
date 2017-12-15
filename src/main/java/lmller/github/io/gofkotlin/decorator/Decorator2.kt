package lmller.github.io.gofkotlin.decorator

infix fun ((String) -> String).then(f: (String) -> String): (String) -> String {
    return { t -> f(this(t)) }
}

operator fun ((String) -> String).plus(f: (String) -> String) = then(f)

infix fun String.decorate(f: (String) -> String): Text {
    return DefaultText(f(this))
}

fun main(args: Array<String>) {
    fun underline(text: String) = "_${text}_"
    fun background(text: String) = "\u001B[43m$text\u001B[0m"

    val text = "Functional?" decorate (::underline then ::background + ::underline)
    text.draw()
}