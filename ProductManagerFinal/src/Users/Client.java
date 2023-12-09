package Users;

import Company.Product;
import Company.Transaction;
import Enums.ID;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Client extends People{
    private ArrayList<Transaction> transactions;
    private @Getter double saldo = 2000000;
    private @Getter @Setter Client referredClient = null;
    public void updateSaldo(double saldo){
        this.saldo += saldo;
    }
    public void addTransactions(Product product){
        transactions.add(new Transaction(product));
    }
    public Client(String nombre, String identificacion, String email, String password, ID TipoDeId) {
        super(nombre, identificacion, email, password, TipoDeId);
        transactions = new ArrayList<>();
    }

}
