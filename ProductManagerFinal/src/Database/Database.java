package Database;

import Enums.ID;
import Exceptions.EmptyTextField;
import Users.Client;
import Users.People;
import lombok.Getter;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Serializable {
    private final @Getter ArrayList<People> users;
    private final @Getter SystemRewards systemRewards;
    public Database(){
        users = new ArrayList<>();
        systemRewards = new SystemRewards(this);
    }
    public People logIn(String email, String password){
        try {
            Checkers.validateEmail(email);
            Checkers.validatePassword(password);
            return CheckUser.searchClientByCredentials(email, password, this);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "EmptyTextField Error", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
    public Client register(String nombre, String identificacion, String email, String password, ID TipoDeId) throws EmptyTextField {
        try{
            if(nombre.isEmpty() || identificacion.isEmpty() || email.isEmpty() || password.isEmpty()) {
                throw new EmptyTextField();
            }
            Checkers.validateEmail(email);
            Checkers.validatePassword(password);
            Client rtnClient = new Client(nombre, identificacion, email, password, TipoDeId);
            users.add(rtnClient);
            return rtnClient;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
}
