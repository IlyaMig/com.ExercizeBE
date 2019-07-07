
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class BasicTax implements Tax {
    private final BigDecimal value;
    private static BasicTax basicTaxInstance;
    private final List<ProductType> types;

    private BasicTax(){
        value= new BigDecimal("0.10");
        this.types = Arrays.asList(ProductType.BOOK,ProductType.FOOD,ProductType.MEDICAL);
    }

    public static BasicTax getInstance(){
        if(basicTaxInstance==null)
            basicTaxInstance = new BasicTax();

        return basicTaxInstance;
    }

    @Override
    public boolean taxRule(Product p) {
        return !types.contains(p.getType());
    }

    public BigDecimal apply(Product p){
        if(taxRule(p))
            return p.getPrice().multiply(value).divide(BigDecimal.valueOf(0.05),0,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(0.05));
        else
            return BigDecimal.valueOf(0.00);
    }

}
