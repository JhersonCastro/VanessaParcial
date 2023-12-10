package Exceptions;

public class NoLenghtPassWord extends Exception{
    public NoLenghtPassWord(){
        super("La contraseña es menor a 8 caracteres");
    }
}
