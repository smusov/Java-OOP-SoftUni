import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.StreamSupport;

public class InstockTests {

    private static final String[] NAMES = {"FirstName", "SecondName", "ThirdName"};
    private static final double[] PRICES = {42.56, 69.69, 13.13};
    private static final int[] QUANTITIES = {69, 42, 13};

    private static final int EXPECTED_SIZE = 69;
    private static final int ZERO_SIZE = 0;
    private static final int INVALID_INDEX = 69;

    private Product firstProduct;
    private Product secondProduct;
    private Product thirdProduct;

    private ProductStock productStock;

    @Before
    public void initialiseProductStock() {

        this.productStock = new Instock();

        this.firstProduct = new Product(NAMES[0], PRICES[1], QUANTITIES[0]);
        this.secondProduct = new Product(NAMES[1], PRICES[0], QUANTITIES[1]);
        this.thirdProduct = new Product(NAMES[2], PRICES[2], QUANTITIES[2]);
    }

    @Test
    public void addProductToStock() {

        addRandomProducts(10, getRandomPrice(5, 20), getRandomQuantity(10));

        this.productStock.add(this.firstProduct);

        Assert.assertTrue(this.productStock.contains(firstProduct));
    }

    @Test
    public void productCountShouldBeSixtyNine() {

        addRandomProducts(69, getRandomPrice(42, 78), getRandomQuantity(12));

        Assert.assertEquals(EXPECTED_SIZE, this.productStock.getCount());
    }

    @Test
    public void productStockShouldContainsProduct() {

        addRandomProducts(10, getRandomPrice(1, 40), getRandomQuantity(63));

        this.productStock.add(this.secondProduct);

        Assert.assertTrue(this.productStock.contains(this.secondProduct));
    }

    @Test
    public void productStockNotShouldContainsProduct() {

        addRandomProducts(10, getRandomPrice(1, 40), getRandomQuantity(57));

        Assert.assertFalse(this.productStock.contains(secondProduct));
    }

    @Test
    public void findProductByIndexShouldEqualsWithThirdProduct() {

        this.productStock.add(this.thirdProduct);

        addRandomProducts(10, getRandomPrice(2, 18), getRandomQuantity(42));

        Product product = this.productStock.find(0);

        Assert.assertEquals(this.thirdProduct, product);

    }

    @Test
    public void findProductByIndexNotShouldEqualsWithThirdProduct() {

        addRandomProducts(10, getRandomPrice(1, 40), getRandomQuantity(10));

        Product product = this.productStock.find(0);

        Assert.assertNotEquals(this.thirdProduct, product);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findProductByInvalidIndexShouldThrowException() {

        addRandomProducts(10, getRandomPrice(1, 40), getRandomQuantity(10));

        this.productStock.find(INVALID_INDEX);

    }

    @Test
    public void findByLabelProductShouldEqualsWithSecondProduct() {
        this.productStock.add(this.thirdProduct);

        addRandomProducts(10, getRandomPrice(1, 40), getRandomQuantity(10));

        Product byLabel = this.productStock.findByLabel(this.thirdProduct.getLabel());

        Assert.assertEquals(this.thirdProduct, byLabel);
    }

    @Test
    public void newQuantityOnTheProductShouldBeTwo() {

        this.productStock.add(firstProduct);
        addRandomProducts(10, getRandomPrice(1, 40), getRandomQuantity(10));
        this.productStock.changeQuantity(NAMES[0], 2);

        int newQuantity = this.productStock.findByLabel(NAMES[0]).getQuantity();

        Assert.assertEquals(2, newQuantity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeQualityMethodShouldThrowExceptionIfProductNonInStock() {
        addRandomProducts(10, getRandomPrice(1, 40), getRandomQuantity(10));
        this.productStock.changeQuantity("Invalid", 42);
    }

    @Test
    public void findFirstNProductSortedByAlphabeticalOrderShouldReturnEmptyIteratorIfThereIsNoAddedElementsOrCountIsNotValid() {
        addRandomProducts(10, getRandomPrice(1, 40), getRandomQuantity(10));

        Iterable<Product> firstByAlphabeticalOrder = this.productStock.findFirstByAlphabeticalOrder(69);

        long size = StreamSupport.stream(firstByAlphabeticalOrder.spliterator(), false).count();

        Assert.assertEquals(ZERO_SIZE, size);

    }

    @Test
    public void findFirstNProductSortedByAlphabeticalOrderShouldReturnCorrectOrder() {

        Product[] products = {
                new Product("A", 5, 5),
                new Product("B", 6, 6),
                new Product("C", 7, 7),
        };

        Arrays.stream(products).forEach(e -> this.productStock.add(e));

        Product[] expected = Arrays.stream(products).toArray(Product[]::new);

        Iterable<Product> firstByAlphabeticalOrder = this.productStock.findFirstByAlphabeticalOrder(3);

        Product[] actual = StreamSupport.stream(firstByAlphabeticalOrder.spliterator(), false).toArray(Product[]::new);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void findProductsInRangeShouldReturnCollectionWithZeroElements() {

        addRandomProducts(10, getRandomPrice(1, 40), getRandomQuantity(10));

        Iterable<Product> allInRange = this.productStock.findAllInRange(50, 55);

        long size = StreamSupport.stream(allInRange.spliterator(), false).count();

        Assert.assertEquals(ZERO_SIZE, size);
    }

    @Test
    public void findAllByQuantityShouldBeReturnEmptyIterator() {
        addRandomProducts(15, getRandomPrice(10, 25), getRandomQuantity(50));
        Iterable<Product> allByQuantity = this.productStock.findAllByQuantity(60);

        long count = StreamSupport.stream(allByQuantity.spliterator(), false).count();

        Assert.assertEquals(ZERO_SIZE, count);

    }

    @Test
    public void findAllByPriceShouldBeReturnEmptyIterator() {
        addRandomProducts(15, getRandomPrice(10, 25), getRandomQuantity(50));
        Iterable<Product> allByQuantity = this.productStock.findAllByPrice(30);

        long count = StreamSupport.stream(allByQuantity.spliterator(), false).count();

        Assert.assertEquals(ZERO_SIZE, count);

    }

    @Test
    public void findAllByPriceShouldBeReturnIteratorWithTwentyProducts() {
        addRandomProducts(20, 50, getRandomQuantity(49));
        Iterable<Product> allByQuantity = this.productStock.findAllByPrice(50);

        long count = StreamSupport.stream(allByQuantity.spliterator(), false).count();

        Assert.assertEquals(20, count);

    }

    @Test
    public void findAllByQuantityShouldBeReturnIteratorWithTwentyProducts() {
        addRandomProducts(20, getRandomPrice(10, 25), 50);
        Iterable<Product> allByQuantity = this.productStock.findAllByQuantity(50);

        long count = StreamSupport.stream(allByQuantity.spliterator(), false).count();

        Assert.assertEquals(20, count);

    }

    @Test(expected = IllegalArgumentException.class)
    public void findFirstMostExpensiveProductsShouldThrowExceptionIfLessThanCountsExist() {
        this.productStock.add(this.firstProduct);
        this.productStock.add(this.secondProduct);
        this.productStock.add(this.thirdProduct);

        this.productStock.findFirstMostExpensiveProducts(4);
    }

    @Test()
    public void findFirstMostExpensiveProductsShouldOfReturnIteratorWithCorrectValues() {
        this.productStock.add(this.firstProduct);
        this.productStock.add(this.secondProduct);
        this.productStock.add(this.thirdProduct);

        Product[] expected = {this.firstProduct,this.secondProduct,this.thirdProduct};

        Iterable<Product> firstMostExpensiveProducts = this.productStock.findFirstMostExpensiveProducts(3);

        Product[] actual = StreamSupport.stream(firstMostExpensiveProducts.spliterator(), false).toArray(Product[]::new);

        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void iteratorShouldBeReturnCorrectValue() {

        List<Product> products = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            products.add(randomProductFactory(getRandomString(), getRandomPrice(5, 50), getRandomQuantity(20)));
        }

        products.forEach(e -> this.productStock.add(e));

        Product[] expected = products.toArray(new Product[0]);
        Product[] actual = StreamSupport.stream(this.productStock.spliterator(), false).toArray(Product[]::new);

        Assert.assertArrayEquals(expected, actual);

    }

    private void addRandomProducts(int count, double price, int quantity) {
        for (int i = 0; i < count; i++) {
            this.productStock.add(randomProductFactory(getRandomString(), price, quantity));
        }
    }

    private Product randomProductFactory(String name, double price, int quantity) {
        return new Product(name, price, quantity);
    }

    private int getRandomQuantity(int bound) {
        return new Random().nextInt(bound);
    }

    private double getRandomPrice(double start, double bound) {
        return ThreadLocalRandom.current().nextDouble(start, bound);
    }

    private String getRandomString() {

        String letterOrDigit = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        StringBuilder salt = new StringBuilder();

        Random rnd = new Random();

        while (salt.length() < 8) {
            int index = (int) (rnd.nextFloat() * letterOrDigit.length());
            salt.append(letterOrDigit.charAt(index));
        }
        return salt.toString();

    }
}
