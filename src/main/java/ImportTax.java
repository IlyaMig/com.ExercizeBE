import java.math.BigDecimal;

public class ImportTax implements Tax {
    private final BigDecimal value;
    private static ImportTax importTaxInstance;

    private ImportTax(){
        value= new BigDecimal("0.05");
    }

    public static ImportTax getInstance(){
        if(importTaxInstance==null)
            importTaxInstance = new ImportTax();

        return importTaxInstance;
    }

    @Override
    public boolean taxRule(Product p) {
        return p.isImported();
    }

    public BigDecimal apply(Product p){
        if(taxRule(p))
            return p.getPrice().multiply(value).divide(BigDecimal.valueOf(0.05),0,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(0.05));
        else
            return BigDecimal.valueOf(0.00);
    }

}
