import java.math.BigDecimal;
import java.util.LinkedList;

public class TaxCalculator {
    private static TaxCalculator taxCalculatorInstance ;
    LinkedList<Tax> taxes;

    private TaxCalculator(){
        taxes = new LinkedList<Tax>();
        taxes.addFirst(BasicTax.getInstance());
        taxes.addFirst(ImportTax.getInstance());
    }

    public static TaxCalculator getInstance(){
        if(taxCalculatorInstance==null)
            taxCalculatorInstance = new TaxCalculator();

        return taxCalculatorInstance;
    }

    public BigDecimal calculateTax(Product p){
        BigDecimal calculatedTax=BigDecimal.valueOf(0.00);
        for (Tax tax : taxes) {
            calculatedTax= calculatedTax.add(tax.apply(p));
        }
        return calculatedTax;
    }
}
