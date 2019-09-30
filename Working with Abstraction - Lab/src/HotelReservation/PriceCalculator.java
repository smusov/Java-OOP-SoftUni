package HotelReservation;

public class PriceCalculator {

    public static double calculatePrice(Reservation reservation){
       double priceWithoutDiscount = reservation.getNumberOfDays()*reservation.getPricePerDay()*reservation.getSeasons().getMultiply();
       double discount = (reservation.getDiscount().getPrecentDiscount()*priceWithoutDiscount)/100;
       return priceWithoutDiscount-discount;
    }
}
