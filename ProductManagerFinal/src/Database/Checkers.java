package Database;

import Exceptions.NoLenghtPassWord;
import Exceptions.PatterIncorrect;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Checkers implements Serializable {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).+$");

    public static void validateEmail(String emailStr) throws PatterIncorrect {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        if(!matcher.matches())
            throw new PatterIncorrect("El email no cumple con las caracteristicas");
    }
    public static void validatePassword(String passStr) throws NoLenghtPassWord, PatterIncorrect {
        if(passStr.length() < 8)
            throw new NoLenghtPassWord();
        Matcher matcher = PASSWORD_PATTERN.matcher(passStr);
        if(!matcher.matches())
            throw new PatterIncorrect("La contraseña no cumple con lo solicitado");
    }
}
