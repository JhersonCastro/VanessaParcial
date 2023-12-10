package Users;

import Enums.ID;

public class Distributor extends People{
    public Distributor(String nombre, String identificacion, String email, String password, ID TipoDeId) {
        super(nombre, identificacion, email, password, TipoDeId);
    }

    @Override
    public String displayInfo() {
        return super.toString()
                + "Distributor{" +
                "inventory=" + inventory +
                '}';
    }


    @Override
    public void login(String email, String password) {

    }

    @Override
    public void logout() {

    }

    @Override
    public void updateProfile(String name, String email) {

    }
}
