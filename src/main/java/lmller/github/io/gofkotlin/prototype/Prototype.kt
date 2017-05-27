package lmller.github.io.gofkotlin.prototype

data class EMail(var recipient: String, var subject: String?, var message: String?) {
    fun quote(startIndex: Int) : String {
        return "> ${message?.substring(startIndex)}"
    }
}

fun main(args: Array<String>) {
    val mail = EMail("abc@example.com", "Hello", "Don't know what to write.")

    val copy = mail.copy(recipient = "other@example.com")

    println("Email1 goes to " + mail.recipient + " with subject " + mail.subject)
    println("Email2 goes to " + copy.recipient + " with subject " + copy.subject)
}