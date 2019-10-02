package jediGalaxyRefactor;

public class Galaxy {

    private int[][] galaxy;

    private int row;
    private int col;

    public Galaxy(int row, int col) {
        this.row = row;
        this.col = col;
        this.galaxy = fillGalaxy(this.row,this.col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getValue (int row , int col){
        return this.galaxy[row][col];
    }

    public void setValue(int row , int col , int value){
        this.galaxy[row][col] = value;
    }

    private int[][] fillGalaxy(int row, int col) {

        int[][] galaxy = new int[row][col];

        int value = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                galaxy[i][j] = value++;
            }
        }
        return galaxy;
    }
}
