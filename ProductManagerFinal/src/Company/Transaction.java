package Company;

import Users.Client;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;
@Getter @Setter
public class Transaction {
    private Product product;
    private Date date;
    private Client client;

    @Override
    public String toString() {
        return "Transaction{" +
                "product=" + product +
                ", date=" + date +
                '}';
    }

    public Transaction(Product product, Client client){
        this.product = product;
        Calendar calendar = Calendar.getInstance();
        this.date = calendar.getTime();
        this.client = client;
    }
}
