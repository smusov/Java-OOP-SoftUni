package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public class OrderItem {
    private String sku;

    private int quantity;

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
