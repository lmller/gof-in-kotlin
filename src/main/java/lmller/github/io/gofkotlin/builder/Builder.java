package lmller.github.io.gofkotlin.builder;

public class Builder {
    public interface CarBuilder {
        void setDoors(int doors);

        void setColor(String color);

        Car build();
    }


    public static final class Car {
        private int doors;
        private String color;

        public Car(int doors, String color) {
            this.doors = doors;
            this.color = color;
        }

        @Override
        public String toString() {
            return String.format("%s car with %d doors", color, doors);
        }

        public static CarBuilder newBuilder(){
            return new Car.BuilderImpl();
        }

        private static class BuilderImpl implements CarBuilder {
            private int doors = 3;
            private String color = "red";

            @Override
            public void setDoors(int doors) {
                this.doors = doors;
            }

            @Override
            public void setColor(String color) {
                this.color = color;
            }

            @Override
            public Car build() {
                return new Car(doors, color);
            }
        }
    }

    public static void main(String[] args) {
        CarBuilder builder = Car.newBuilder();

        builder.setColor("green");
        builder.setDoors(5);

        Car car = builder.build();

        System.out.println(car);
    }
}
