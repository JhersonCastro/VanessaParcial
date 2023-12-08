package Users;

import Enums.ID;

public class Distributor extends People{
    public Distributor(String nombre, String identificacion, String email, String password, ID TipoDeId) {
        super(nombre, identificacion, email, password, TipoDeId);
    }
}
