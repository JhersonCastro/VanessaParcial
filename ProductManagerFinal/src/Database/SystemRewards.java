package Database;

import Users.Client;
import Users.People;

import javax.xml.crypto.Data;
import java.util.Optional;

public class SystemRewards {
    private Database data;
    public SystemRewards(Database database) {
        data = database;
    }

    public void reward(String referredID, Client client){
        try{
            Client clienteQueRefiere = CheckUser.searchClientById(referredID, data);
            if(clienteQueRefiere != null){
                clienteQueRefiere.updateSaldo(15000);
                client.updateSaldo(30000);
            }
        }catch (Exception ex){
            System.out.println("No se pudo hacer el cast " + ex.getMessage());
        }

    }
}
