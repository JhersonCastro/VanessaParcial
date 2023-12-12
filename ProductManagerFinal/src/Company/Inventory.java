package Company;

import Exceptions.EmptyTextField;
import Exceptions.ResourceNotFound;
import Users.Distributor;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable {
    private final int capacidad = 50;
    private @Getter ArrayList<Product> products;
    private final ArrayList<Distributor> distributors;
    public Inventory() {
        products = new ArrayList<>();
        distributors = new ArrayList<>();
    }
    public void addDistributor(Distributor distributor){
        distributors.add(distributor);
    }
    public static Product createProduct(String ID, String name, String description, String price, String amount) throws NumberFormatException, EmptyTextField {
        double priceParse;
        int amountParse;
        priceParse = Double.parseDouble(price);
        amountParse = Integer.parseInt(amount);
        return new Product(ID, name, description, priceParse, amountParse);
    }


    public void setOrAddProduct(Product product) {
        if(getProducts().size() <= capacidad){
            int index;
            try{
                index = searchIndexByID(product);
                getProducts().set(index, product);
            }catch (ResourceNotFound ex){
                if(products.size() <= capacidad)
                    getProducts().add(product);
            }
        }else{
            System.out.println("Esta lleno el vector");
        }
    }
    private int searchIndexByID(Product product) throws ResourceNotFound{
        for (int i = 0; i< getProducts().size(); i++){
            if(getProducts().get(i).getID().equals(product.getID()))
                return i;
        }
        throw new ResourceNotFound("No se encontro el producto con el mismo ID, se va a crear uno nuevo");
    }

    public void eliminarProducto(Product producto) {
        if (products.contains(producto)) {
            products.remove(producto);
            System.out.println("Producto eliminado con éxito.");
        } else {
            System.out.println("Producto no encontrado en el inventario.");
        }
    }

    public void generarInforme() {
        System.out.println("Informe de inventario:");
        for (Product producto : products) {
            System.out.println(producto.toString());
        }
    }

}
