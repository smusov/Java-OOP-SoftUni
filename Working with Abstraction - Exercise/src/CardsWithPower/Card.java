package CardsWithPower;

public class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    private int getPower(){
        return RankPowers.valueOf(this.rank).getValue()+SuitPowers.valueOf(this.suit).getValue();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",this.rank,this.suit,getPower());
    }
}
