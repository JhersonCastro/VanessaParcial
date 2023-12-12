package Users;

import Company.Inventory;
import Company.Product;
import Company.Transaction;
import Enums.ID;
import IU.Client.UIUser;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Client extends People implements IUser{
    private final @Getter ArrayList<Transaction> transactions;
    private @Getter double saldo = 200000;
    private @Getter @Setter Client referredClient = null;
    public void updateSaldo(double saldo){
        this.saldo += saldo;
    }
    public void addTransactions(Product product){
        transactions.add(new Transaction(product, this));
    }
    public Client(String nombre, String identificacion, String email, String password, ID TipoDeId) {
        super(nombre, identificacion, email, password, TipoDeId);
        transactions = new ArrayList<>();
    }


    @Override
    public String displayInfo() {
        return super.toString()
                + "Client{" +
                "transactions=" + transactions +
                ", saldo=" + saldo +
                ", referredClient=" + referredClient +
                '}';
    }


    @Override
    public void login(Inventory inventory) {
        UIUser user = new UIUser(this,inventory);
    }

    @Override
    public void updateProfile(String name, String email) {
        //TODO: CODE HERE
    }
}
