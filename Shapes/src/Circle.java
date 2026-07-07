public class Circle extends Shape {
    private double radius;

    // Конструктор для того чтобы можно было в main задавать свои параметры объекта
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getDiameter() {
        return getRadius() * 2;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void printInfo() {
        System.out.print("Я круг, моя площадь равна: " + getArea());
    }
}
