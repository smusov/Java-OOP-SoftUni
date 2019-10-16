package shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public void calculatePerimeter() {

        Double perimeter = this.height + this.width * 2;

        super.setPerimeter(perimeter);
    }

    @Override
    public void calculateArea() {

        Double area = this.height * this.width;

        super.setArea(area);
    }
}
