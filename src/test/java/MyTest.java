import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.math.BigDecimal;

public class MyTest {
    private Product book1;
    private Product musicCD;
    private Product chocolateBar;
    private Product boxChocolate;
    private Product bottlePerfume;
    private Product importedBoxChocolate;
    private Product bottlePerfume2;
    private Product importedBottlePerfume;
    private Product headache;

    @Before
    public void setUp() {
        setUpProducts();
    }

    private void setUpProducts() {
        //Creating Products
        book1 = Product.create("book", ProductType.BOOK, false, BigDecimal.valueOf(12.49));
        musicCD = Product.create("musicCD", ProductType.OTHER, false, BigDecimal.valueOf(14.99));
        chocolateBar = Product.create("chocolateBar", ProductType.FOOD, false, BigDecimal.valueOf(0.85));
        boxChocolate = Product.create("box of chocolate", ProductType.FOOD, true, BigDecimal.valueOf(10.00));
        bottlePerfume = Product.create("bottle of perfume", ProductType.OTHER, true, BigDecimal.valueOf(47.50));
        importedBoxChocolate = Product.create("imported box of chocolate", ProductType.FOOD, true, BigDecimal.valueOf(11.25));
        bottlePerfume2 = Product.create("bottle of perfume 2", ProductType.OTHER, false, BigDecimal.valueOf(18.99));
        importedBottlePerfume = Product.create("imported bottle of perfume", ProductType.OTHER, true, BigDecimal.valueOf(27.99));
        headache = Product.create("packet of headache pills", ProductType.MEDICAL, false, BigDecimal.valueOf(9.75));

    }

    @Test
    public void Purchase_1() {
        //Creating an Order
        Order order = new Order();
        order.addProduct(book1, 1);
        order.addProduct(musicCD, 1);
        order.addProduct(chocolateBar,1);

        Assert.assertEquals(order.getTotal().toString(), "29.83");
        Assert.assertEquals(order.getTotalSalesTaxes().toString(), "1.50");

        System.out.println(order.printReceipt());
    }

    @Test
    public void Purchase_2() {
        //Creating an Order
        Order order = new Order();
        order.addProduct(boxChocolate, 1);
        order.addProduct(bottlePerfume,1);

        Assert.assertEquals(order.getTotal().toString(), "65.15");
        Assert.assertEquals(order.getTotalSalesTaxes().toString(), "7.65");

        System.out.println(order.printReceipt());
    }

    @Test
    public void Purchase_3() {
        //Creating an Order
        Order order = new Order();
        order.addProduct(importedBoxChocolate, 1);
        order.addProduct(bottlePerfume2,1);
        order.addProduct(importedBottlePerfume,1);
        order.addProduct(headache,1);

        //Assert.assertEquals(order.getTotal().toString(), "74.68");
        //Assert.assertEquals(order.getTotalSalesTaxes().toString(), "6.70");

        System.out.println(order.printReceipt());
    }

}
