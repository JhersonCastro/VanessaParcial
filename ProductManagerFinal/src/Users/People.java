package Users;

import Enums.ID;
import lombok.Getter;

import java.io.Serializable;

public abstract class People implements Serializable {
    @Getter
    private final String
    nombre;
    @Getter
    private final String identificacion;
    @Getter
    private final String email;
    @Getter
    private final String password;
    private final ID TipoDeId;

    public People(String nombre, String identificacion, String email, String password, ID tipoDeId) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
        this.password = password;
        TipoDeId = tipoDeId;
    }


    public String displayInfo(){
        return "People{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", TipoDeId=" + TipoDeId +
                '}';
    }
}
