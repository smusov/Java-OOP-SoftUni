package jediGalaxyRefactor;

public class Game {

    private Player player;
    private Evil evil;
    private Galaxy galaxy;

    public Game(Player player, Evil evil, Galaxy galaxy) {

        this.player = player;
        this.evil = evil;
        this.galaxy = galaxy;

    }

    public void startGame() {
        destroyingCells();
        calculateAndSetPlayerPoints();
    }

    private void destroyingCells () {

        int galaxyRow = this.galaxy.getRow();
        int galaxyCol = this.galaxy.getCol();

        int row = this.evil.getRow();
        int col = this.evil.getCol();

        while (row >= 0 && col >= 0 ) {

            if (row < galaxyRow && col < galaxyCol){
                this.galaxy.setValue(row, col, 0);
            }
            row--;
            col--;
        }

    }

    private void calculateAndSetPlayerPoints() {

        int points = 0;

        int galaxyRow = this.galaxy.getRow();
        int galaxyCol = this.galaxy.getCol();

        int playerRow = this.player.getRow();
        int playerCol = this.player.getCol();

        while (playerRow >= 0 && playerCol < galaxyCol) {


            if (playerRow < galaxyRow && playerCol>=0 ){
                points+= this.galaxy.getValue(playerRow,playerCol);
            }

            playerRow--;
            playerCol++;
        }

       this.player.setPoints(this.player.getPoints()+points);
    }
}
