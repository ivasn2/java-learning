public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getDiagonal() {
        return Math.sqrt(width * width + height * height);
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public void printInfo() {
        System.out.print("Я прямоугольник, моя площадь равна: " + getArea());
    }
}
