import java.math.BigDecimal;

public class Product {

    public static Product create(String name, ProductType type, boolean imported, BigDecimal price) {
        return new Product(name, type, imported, price);
    }

    private final String name;
    private final ProductType type;
    private final boolean imported;
    private final BigDecimal price;
    private final BigDecimal taxPrice;

    private Product(String name, ProductType type, boolean imported, BigDecimal price) {
        this.name = name;
        this.type = type;
        this.imported = imported;
        this.price = price;
        this.taxPrice=TaxCalculator.getInstance().calculateTax(this);
    }

    public String getName() {
        return name;
    }

    public ProductType getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTaxPrice() {
        return taxPrice;
    }

    public boolean isImported() {
        return imported;
    }

    public boolean equals(Object o){
        if(! (o instanceof Product))
            return false;

        Product p = (Product) o;
        return  name.equals(p.name) && type==p.type && imported==p.imported &&
                price==p.price && taxPrice==p.taxPrice;
    }

    public int hashCode(){
        return name.hashCode() ^ type.hashCode() ^ ((Boolean)imported).hashCode() ^
                price.hashCode() ^ taxPrice.hashCode();
    }

}
