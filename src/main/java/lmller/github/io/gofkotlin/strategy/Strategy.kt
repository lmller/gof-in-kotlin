package lmller.github.io.gofkotlin.strategy

typealias Discount = (Double) -> Double

class Customer(val name: String, val fee: Double, val discount: Discount) {
    fun pricePerMonth(): Double {
        return discount(fee)
    }
}

val studentDiscount = { raw: Double -> raw/2 }
val noDiscount = { raw: Double -> raw }

fun main(args: Array<String>) {

    val student = Customer("Ned", 10.0, studentDiscount)
    val regular = Customer("John", 10.0, noDiscount)

    println("${student.name} pays %.2f per month".format(student.pricePerMonth()))
    println("${regular.name} pays %.2f per month".format(student.pricePerMonth()))

}
