import java.math.BigDecimal;

public interface Tax {
    boolean taxRule(Product p);
    static Tax getInstance(){return null;}
    BigDecimal apply(Product p);
}
