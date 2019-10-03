package greedyTimesRefactor.Items;

import java.util.LinkedHashMap;

public class Gem {
    private LinkedHashMap<String, Long> map;
    private long quantity;

    public Gem() {
        this.map = new LinkedHashMap<>();
    }

    public void addGem(String type, long quantity) {

        this.map.putIfAbsent(type, 0L);
        this.map.put(type, this.map.get(type) + quantity);
        this.quantity += quantity;
    }

    public long getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("<Gem> $%s", this.quantity));
        sb.append(System.lineSeparator());

        this.map.entrySet().stream().sorted((e1, e2) -> {
            int compare = e2.getKey().compareTo(e1.getKey());

            if (compare == 0) {
                compare = Long.compare(e1.getValue(), e2.getValue());
            }
            return compare;
        }).forEach(e -> {
            sb.append(String.format("##%s - %s", e.getKey(), e.getValue()));
            sb.append(System.lineSeparator());
        });

        return this.map.size() > 0 ? sb.toString() : "";
    }
}
