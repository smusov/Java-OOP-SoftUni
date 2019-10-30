package solidLab.p03_LiskovSubstitution.p01_Square;

public class Square extends Shape {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return this.side*4;
    }
}
