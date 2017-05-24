package lmller.github.io.gofkotlin.interpreter;

public class Interpreter {
    public interface Expression {
        int eval();
    }

    public static class Add implements Expression {

        final Expression leftHand;
        final Expression rightHand;

        public Add(Expression leftHand, Expression rightHand) {
            this.leftHand = leftHand;
            this.rightHand = rightHand;
        }

        @Override
        public int eval() {
            return leftHand.eval() + rightHand.eval();
        }

        @Override
        public String toString() {
            return leftHand.toString() +" + " + rightHand.toString();
        }
    }

    public static class Subtract implements Expression {

        final Expression leftHand;
        final Expression rightHand;

        public Subtract(Expression leftHand, Expression rightHand) {
            this.leftHand = leftHand;
            this.rightHand = rightHand;
        }

        @Override
        public int eval() {
            return leftHand.eval() - rightHand.eval();
        }
        @Override
        public String toString() {
            return leftHand.toString() +" - " + rightHand.toString();
        }

    }

    public static class Number implements Expression {
        final int value;

        public Number(int value) {
            this.value = value;
        }

        @Override
        public int eval() {
            return value;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    public static void main(String[] args) {
        //this expression would normally be parsed, but I'm too lazy to write a parser
        Expression expression = new Add(new Number(40), new Subtract(new Number(10), new Number(8)));

        printExpression(expression);
    }


    public static void printExpression(Expression expression) {
        System.out.println(expression.toString() + " = " + expression.eval());
    }

}
