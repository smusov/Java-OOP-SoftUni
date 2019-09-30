package HotelReservation;

public enum Seasons {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);

    private int season;

    Seasons(int value) {
        this.season = value;
    }
    public int getMultiply (){
        return this.season;
    }
}
