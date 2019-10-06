package ClassBox;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {

        setLength(length);
        setWidth(width);
        setHeight(height);

    }

    private void setLength(double length) {
        validateData(length, "length");
        this.length = length;
    }

    private void setWidth(double width) {
        validateData(width, "width");
        this.width = width;
    }

    private void setHeight(double height) {
        validateData(height, "height");
        this.height = height;
    }

    private void validateData(double data, String method) {
        if (data <= 0) {
            throw new IllegalArgumentException(String.format("%s cannot be zero or negative.", method));
        }
    }

    public double calculateSurfaceArea() {
        return 2 * (this.length * this.height) + 2*(this.length * this.width) +2*(this.width * this.height);
    }
    public double calculateLateralSurfaceArea (){
        return 2*(this.length*this.height) + 2 *(this.width * this.height);
    }
    public double calculateVolume (){
        return this.length*this.width*this.height;
    }
}
