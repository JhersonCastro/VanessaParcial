package Company;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;
@Getter @Setter
public class Transaction {
    private Product product;
    private Date date;
    public Transaction(Product product){
        this.product = product;
        Calendar calendar = Calendar.getInstance();
        this.date = calendar.getTime();
    }
}
