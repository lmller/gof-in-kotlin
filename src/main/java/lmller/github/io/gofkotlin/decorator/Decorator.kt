package lmller.github.io.gofkotlin.decorator

interface Text {
    fun draw()
}

class DefaultText(val text: String) : Text {
    override fun draw() {
        print(text)
    }
}

fun Text.underline(decorated: Text.() -> Unit) {
    print("_")
    this.decorated()
    print("_")
}

fun Text.background(decorated: Text.() -> Unit) {
    print("\u001B[43m")
    this.decorated()
    print("\u001B[0m")
}

fun main(args: Array<String>) {
    DefaultText("Hello").run {
        background {
            underline {
                draw()
            }
        }
    }
}