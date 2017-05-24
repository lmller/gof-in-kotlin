package lmller.github.io.gofkotlin.strategy;

public class Strategy {
    interface Discount {
        double discountedPrice(double raw);
    }
    
    public static class NoDiscount implements Discount {
        @Override
        public double discountedPrice(double raw) {
            return raw;
        }
    }
    
    public static class StudentDiscount implements Discount {
        @Override
        public double discountedPrice(double raw) {
            return 0.5 * raw;
        }
    }

    public static class Customer {
        final String name;
        final double fee;
        final Discount discount;

        public Customer(String name, double fee, Discount discount) {
            this.name = name;
            this.fee = fee;
            this.discount = discount;
        }

        public double pricePerMonth() {
            return discount.discountedPrice(fee);
        }
    }

    public static void main(String[] args) {
        Customer student = new Customer("Ned", 10, new StudentDiscount());
        Customer regular = new Customer("John", 10, new NoDiscount());

        System.out.println(String.format("%s pays %.2f per month", student.name, student.pricePerMonth()));
        System.out.println(String.format("%s pays %.2f per month", regular.name, regular.pricePerMonth()));

    }
}
