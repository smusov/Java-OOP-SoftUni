package HotelReservation;

public class Reservation {
    private double pricePerDay;
    private int numberOfDays;

    private Seasons seasons;
    private Discount discountType;

    public Reservation(double pricePerDay, int numberOfDays, Seasons seasons, Discount discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.seasons = seasons;
        this.discountType = discountType;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public Seasons getSeasons() {
        return seasons;
    }

    public Discount getDiscount() {
        return this.discountType;
    }
}
