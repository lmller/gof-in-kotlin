package lmller.github.io.gofkotlin.interpreter

sealed class Expression {
    abstract fun eval(): Int

    //personally, I'd still put this into the concrete classes.
    //however, this is nice to show the `when`-expression in combination with `sealed` classes
    //that could be used inside the Expression parser
    override fun toString() = when(this) {
        is Add -> "$leftHand + $rightHand"
        is Subtract -> "$leftHand - $rightHand"
        is Number -> "$value"
    }
}

class Add(val leftHand: Expression, val rightHand: Expression) : Expression() {
    override fun eval() = leftHand.eval() + rightHand.eval()
}

class Subtract(val leftHand: Expression, val rightHand: Expression) : Expression() {
    override fun eval() = leftHand.eval() - rightHand.eval()
}

class Number(val value: Int) : Expression() {
    override fun eval() = value
}

fun main(args: Array<String>) {
    //this expression would normally be parsed, but I'm too lazy to write a parser
    val expression = Add(Number(40), Subtract(Number(10), Number(8)))

    printExpression(expression)
}


fun printExpression(expression: Expression) {
    println(expression.toString() + " = " + expression.eval())
}