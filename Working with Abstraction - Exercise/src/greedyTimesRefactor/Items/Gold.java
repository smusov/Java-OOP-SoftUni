package greedyTimesRefactor.Items;

import java.util.LinkedHashMap;

public class Gold {

    private static String GOLD_ITEM = "Gold";

    private LinkedHashMap<String, Long> map;
    private long quantity;

    public Gold() {
        this.map = new LinkedHashMap<>();
    }

    public void addGold(long quantity) {

        this.map.putIfAbsent(GOLD_ITEM, 0L);
        this.map.put(GOLD_ITEM, this.map.get(GOLD_ITEM) + quantity);
        this.quantity += quantity;
    }

    public long getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return this.map.size() > 0 ? String.format("<Gold> $%d%n##Gold - %d%n", this.quantity, map.get(GOLD_ITEM)) : "";
    }
}
