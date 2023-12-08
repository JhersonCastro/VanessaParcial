package Users;

import Enums.ID;

public abstract class People {
    private String
    nombre, identificacion, email, password;
    private  ID TipoDeId;

    public People(String nombre, String identificacion, String email, String password, ID tipoDeId) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
        this.password = password;
        TipoDeId = tipoDeId;
    }
}
