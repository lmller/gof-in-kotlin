package lmller.github.io.gofkotlin.visitor;

import java.util.Arrays;
import java.util.List;

public class Visitor {
    interface Shape {
        <T> T accept(ShapeVisitor<T> visitor);
    }

    public static class Square implements Shape {
        final double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public <T> T accept(ShapeVisitor<T> visitor) {
            return visitor.visit(this);
        }
    }

    public static class Circle implements Shape {
        final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public <T> T accept(ShapeVisitor<T> visitor) {
            return visitor.visit(this);
        }
    }

    public static class Rectangle implements Shape {
        final double width;
        final double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public <T> T accept(ShapeVisitor<T> visitor) {
            return visitor.visit(this);
        }
    }

    interface ShapeVisitor<T> {
        T visit(Square element);

        T visit(Circle element);

        T visit(Rectangle element);
    }

    public static class AreaVisitor implements ShapeVisitor<Double> {
        public Double visit(Square element) {
            return element.side * element.side;
        }

        public Double visit(Circle element) {
            return Math.PI * element.radius * element.radius;
        }

        public Double visit(Rectangle element) {
            return element.height * element.width;
        }
    }

    public static class PerimeterVisitor implements ShapeVisitor<Double> {
        public Double visit(Square element) {
            return 4 * element.side;
        }

        public Double visit(Circle element) {
            return 2 * Math.PI * element.radius;
        }

        public Double visit(Rectangle element) {
            return (2 * element.height + 2 * element.width);
        }
    }

    public static void main(String[] args) {
        List<Shape> figures = Arrays.asList(new Circle(4), new Square(5), new Rectangle(6, 7));

        double totalArea = 0.0;
        ShapeVisitor<Double> areaVisitor = new AreaVisitor();
        for (Shape figure : figures) {
            totalArea += figure.accept(areaVisitor);
        }
        System.out.println("Total area = " + totalArea);

        double totalPerimeter = 0.0;
        ShapeVisitor<Double> perimeterVisitor = new PerimeterVisitor();
        for (Shape figure : figures) {
            totalPerimeter += figure.accept(perimeterVisitor);
        }
        System.out.println("Total perimeter = " + totalPerimeter);
    }
}
