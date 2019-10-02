package jediGalaxyRefactor;

public class Player {

    private int row;
    private int col;
    private long points;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public long getPoints() {
        return points;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setPoints(long points) {
        this.points = points;
    }
}
