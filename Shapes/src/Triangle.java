public class Triangle extends Shape {
    private double height;
    private double footing;

    public Triangle(double height, double footing) {
        this.height = height;
        this.footing = footing;
    }

    public double getFooting() {
        return footing;
    }

    @Override
    public double getArea() {
        return ((height * footing) / 2);
    }

    @Override
    public void printInfo() {
        System.out.print("Я треугольник, моя площадь равна: " + getArea());
    }
}
