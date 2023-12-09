package Users;

import Enums.ID;
import lombok.Getter;

public abstract class People {
    @Getter
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

    public void menu(){
    }
}
