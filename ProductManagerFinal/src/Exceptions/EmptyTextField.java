package Exceptions;

public class EmptyTextField extends Exception {
    public EmptyTextField(){
        super("¡No puedes dejar cajas de texto vacias!");
    }
}
