package PointInRectangle;

public class Rectangle {
    private int bottomLeftX;
    private int bottomLeftY;
    private int topRightX;
    private int topRightY;

    public Rectangle(int bottomLeftX, int bottomLeftY, int topRightX, int topRightY) {
        this.bottomLeftX = bottomLeftX;
        this.bottomLeftY = bottomLeftY;
        this.topRightX = topRightX;
        this.topRightY = topRightY;
    }
    public boolean contains (Point point){
        boolean isInside = false;

        if (point.getX()>=this.bottomLeftX&&point.getX()<=this.topRightX&&point.getY()>=this.bottomLeftY&&point.getY()<=this.topRightY){
            isInside = true;
        }


        return isInside;
    }
}
