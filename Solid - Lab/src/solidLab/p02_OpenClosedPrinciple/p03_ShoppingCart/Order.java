package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public abstract class Order {
    private final Cart cart;
    private Cart card;

    protected Order(Cart cart) {
        this.cart = cart;
    }

    public double getTotalAmount() {
        double total = 0;

        for(var item : this.card.getItems())
        {
            if (item.getSku().startsWith("EACH")) {
                total += item.getQuantity() * 5.0;
            } else if (item.getSku().startsWith("WEIGHT")) {
                // quantity is in grams, price is per kg
                total += item.getQuantity() * 4.0 / 1000;
            } else if (item.getSku().startsWith("SPECIAL")) {
                // $0.40 each; 3 for $1.00
                total += item.getQuantity() * 4.0;
                int setsOfThree = item.getQuantity() / 3;
                total -= setsOfThree * 2.0;
            }

            // more rules are coming!
        }

        return total;
    }
}
