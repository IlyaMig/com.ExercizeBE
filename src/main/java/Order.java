import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Order {
    private final HashMap<Product,Integer> entries = new HashMap<Product,Integer>();
    private BigDecimal totalSalesTaxes = BigDecimal.valueOf(0.00);
    private BigDecimal total = BigDecimal.valueOf(0.00);

    public void addProduct(Product p, int quantity){
        entries.put(p,quantity);
        totalSalesTaxes = totalSalesTaxes.add(p.getTaxPrice().multiply(BigDecimal.valueOf(quantity)));
        total = total.add(p.getPrice().add(p.getTaxPrice()).multiply(BigDecimal.valueOf(quantity)));
    }

    public String printReceipt(){
        String receipt="";

        Iterator it = entries.entrySet().iterator();

        while (it.hasNext()) {

            Map.Entry entry = (Map.Entry)it.next();

            receipt += entry.getValue() +" "+ ((Product)entry.getKey()).getName() + " : " + ((Product)entry.getKey()).getPrice().add(((Product)entry.getKey()).getTaxPrice()) +"\n";

        }

        receipt += "Sales Taxes : " + totalSalesTaxes+"\n";

        receipt += "Total : " + total+"\n";

        return receipt;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public BigDecimal getTotalSalesTaxes() {
        return totalSalesTaxes;
    }

}
