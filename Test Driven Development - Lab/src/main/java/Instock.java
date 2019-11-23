import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private Map<String, Product> products;

    public Instock() {
        this.products = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.products.containsValue(product);
    }

    @Override
    public void add(Product product) {
        this.products.put(product.getLabel(), product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        containsProduct(product);
        this.products.get(product).setQuantity(quantity);
    }

    @Override
    public Product find(int index) {
        return new ArrayList<>(this.products.values()).get(index);
    }

    @Override
    public Product findByLabel(String label) {

        containsProduct(label);

        return this.products.get(label);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {

        if (count <= 0 || count > this.products.size()) {
            return new TreeSet<>();
        }

        return this.products.values().stream().limit(count).sorted(Comparator.comparing(Product::getLabel)).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return this.products.values().stream().filter(e -> e.getPrice() > lo && e.getPrice() <= hi)
                .sorted((e1, e2) -> Double.compare(e2.getPrice(), e1.getPrice())).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return this.products.values().stream().filter(e -> e.getPrice() == price).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {

        List<Product> productList = this.products
                .values()
                .stream()
                .sorted((e1,e2)->Double.compare(e2.getPrice(),e1.getPrice()))
                .limit(count)
                .collect(Collectors.toList());

        if (productList.size() < count) {
            throw new IllegalArgumentException();
        }

        return productList;

    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.products.values().stream().filter(e -> e.getQuantity() == quantity).collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return this.products.values().iterator();
    }

    private void containsProduct(String label) {
        if (!this.products.containsKey(label)) {
            throw new IllegalArgumentException();
        }
    }
}
