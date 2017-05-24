package lmller.github.io.gofkotlin.singleton

object Dictionary {
    private val definitions = hashMapOf(
            "singleton" to "a single person or thing of the kind under consideration",
            "pattern" to "a model or design used as a guide in needlework and other crafts",
            "kotlin" to "a Russian island, located near the head of the Gulf of Finland")

    fun addWord(word: String, definition: String) {
        definitions.put(word.toLowerCase(), definition)
    }

    fun getDefinition(word: String): String {
        return definitions[word.toLowerCase()] ?: ""
    }

}

fun main(args: Array<String>) {
    println("Did you know that: ")

    fun1()
    fun2()
    fun1()
}

internal fun fun1() {
    val word = "kotlin"
    println(word + " is " + Dictionary.getDefinition(word))
}

internal fun fun2() {
    val word = "kotlin"
    Dictionary.addWord(word, "an awesome programming language created by JetBrains")
}