package Database;

import Users.Client;

import javax.swing.*;
import java.io.Serializable;

public class SystemRewards implements Serializable {
    private final Database data;
    public SystemRewards(Database database) {
        data = database;
        if(data != null)
            JOptionPane.showMessageDialog(null, "Conexion a base de datos exitosa", "Conexion", JOptionPane.INFORMATION_MESSAGE);
    }

    public void reward(Client oldClient, Client newClient){
        try{
            newClient.setReferredClient(oldClient);
            newClient.updateSaldo(15000);
            oldClient.updateSaldo(30000);
        }catch (Exception ex){
            System.out.println("No se pudo hacer el cast " + ex.getMessage());
        }

    }
}
