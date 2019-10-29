package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<OrderItem> items;

    public String customerEmail;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public Iterable<OrderItem> getItems() {
        return new ArrayList<>(this.items);
    }


    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void add(OrderItem orderItem) {
        this.items.add(orderItem);
    }


}
