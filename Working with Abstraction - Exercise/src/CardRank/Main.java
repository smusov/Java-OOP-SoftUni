package CardRank;

public class Main {
    public static void main(String[] args){

        Cards[] values = Cards.values();

        System.out.println("Card Ranks:");

        for (Cards value : values) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s",value.ordinal(),value));
        }
    }
}