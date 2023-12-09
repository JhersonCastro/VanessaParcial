package Database;

import Users.People;
import lombok.Getter;

import java.util.ArrayList;

public class Database {
    private @Getter ArrayList<People> users;
    SystemRewards systemRewards;
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
