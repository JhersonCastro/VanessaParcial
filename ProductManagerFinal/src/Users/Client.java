package Users;

import Company.Product;
import Enums.ID;

import java.util.Date;
import java.util.Map;

public class Client extends People{
    private Map<Product, Date> transactions;
    private Client referredClient;

    public Client(String nombre, String identificacion, String email, String password, ID TipoDeId) {
        super(nombre, identificacion, email, password, TipoDeId);
    }
    public void promoteToVIP(){

    }
}
