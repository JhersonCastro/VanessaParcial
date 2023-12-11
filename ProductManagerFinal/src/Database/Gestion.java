package Database;

import Company.Inventory;
import java.io.*;

public class Gestion {
    public <T> void guardarEnArchivo(String nombreArchivo, T datos){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(datos);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Se guardaron correctamente los datos");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public enum TIPODECLASE{
        INVENTORY,
        DATABASE
    }
    public Object cargarDesdeArchivo(String nombreArchivo, TIPODECLASE td){
        Object datos;
        try {
            FileInputStream fileInputStream = new FileInputStream(nombreArchivo);
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            datos = in.readObject();
            in.close();
            fileInputStream.close();
            System.out.println("Se cargaron correctamente los datos");
            return datos;
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        switch (td){
            case INVENTORY -> {
                return new Inventory();
            }
            case DATABASE -> {
                return new Database();
            }
            default -> {
                return new Object();
            }
        }
    }
}
