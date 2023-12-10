package Database;

import Enums.ID;
import Exceptions.EmptyTextField;
import Exceptions.NoLenghtPassWord;
import Exceptions.PatterIncorrect;
import Exceptions.ResourceNotFound;
import Users.Client;
import Users.People;
import lombok.Getter;

import javax.swing.*;
import java.util.ArrayList;

public class Database {
    private @Getter ArrayList<People> users;
    private SystemRewards systemRewards;
    public Database(){
        users = new ArrayList<>();
        systemRewards = new SystemRewards(this);
    }
    public void delete(People people){
        users.remove(people);
    }
    public void create(Database data, People user){
        users.add(user);
    }
}
