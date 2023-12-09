package Database;

import Exceptions.ResourceNotFound;
import Users.Client;
import Users.People;

import java.util.Optional;

public class CheckUser {
    public static Client searchClientById(String ID, Database data) throws ResourceNotFound {
        Optional<People> theClient = data.getUsers().stream().filter(client -> client.getIdentificacion().equals(ID)).findFirst();
        if(theClient.orElse(null) == null){
            throw new ResourceNotFound("El cliente no se encuentra");
        }
        return (Client) theClient.orElse(null);
    }
}
