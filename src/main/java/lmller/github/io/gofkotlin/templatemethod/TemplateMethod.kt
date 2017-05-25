package lmller.github.io.gofkotlin.templatemethod

fun execute(task: () -> Unit) {
    val startTime = System.currentTimeMillis()
    task()
    println("Work took ${System.currentTimeMillis() - startTime} millis")
}


fun main(args: Array<String>) {
    execute {
        println("Working...")
    }
}
