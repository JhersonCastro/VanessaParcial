package Users;

import Enums.ID;

import java.util.Calendar;
import java.util.Date;

public class VIPClient extends Client{
    private String numCard;
    private Date creationDate, expirationDate;
    private final double DISCOUNT = 0.9;
    public VIPClient(String nombre, String identificacion, String email, String password, ID TipoDeId) {
        super(nombre, identificacion, email, password, TipoDeId);
        creationDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        this.expirationDate = calendar.getTime();
    }
}
