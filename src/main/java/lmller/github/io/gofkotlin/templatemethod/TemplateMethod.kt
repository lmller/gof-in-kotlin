package lmller.github.io.gofkotlin.templatemethod

fun trackTime(task: () -> Unit) {
    val startTime = System.currentTimeMillis()
    task()
    println("Work took ${System.currentTimeMillis() - startTime} millis")
}


fun main(args: Array<String>) {
    trackTime {
        println("Working...")
    }
}
