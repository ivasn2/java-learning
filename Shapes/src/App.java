import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        ArrayList<Shape> shapes = new ArrayList<Shape>();
        double totalArea = 0;
        int circleCounts = 0;
        int rectangleCounts = 0;
        int triangleCounts = 0;

        shapes.add(new Circle(3.5)); // <-- upcasting
        shapes.add(new Rectangle(3.2, 52)); // <-- upcasting
        shapes.add(new Triangle(123, 321.2)); // <-- upcasting

        for (Shape shape : shapes) {

            if (shape instanceof Circle) {

                circleCounts += 1;
                Circle circle = (Circle) shape; // <-- down-casting
                circle.getDiameter();

            } else if (shape instanceof Triangle) {

                triangleCounts += 1;
                Triangle triangle = (Triangle) shape;
                triangle.getFooting();

            } else if (shape instanceof Rectangle) {

                rectangleCounts += 1;
                Rectangle rectangle = (Rectangle) shape;
                rectangle.getDiagonal();

            }

            totalArea += shape.getArea();
            shape.printInfo();
            System.out.println();
        }

        System.out.println("Общая площадь равна: " + totalArea);
        System.out.println("Всего Circle: " + circleCounts);
        System.out.println("Всего Rectangle: " + rectangleCounts);
        System.out.println("Всего Triangle: " + triangleCounts);

    }
}
