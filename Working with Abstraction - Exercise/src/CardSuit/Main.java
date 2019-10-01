package CardSuit;

public class Main {
    public static void main(String[] args) {

        CardDeck[] values = CardDeck.values();

        System.out.println("Card Suits:");

        for (int i = 0; i < values.length; i++) {
            System.out.println(String.format("Ordinal value: %s; Name value: %s",i,values[i]));
        }
    }
}
