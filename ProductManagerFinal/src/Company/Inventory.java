package Company;

import Exceptions.EmptyTextField;
import Exceptions.ResourceNotFound;
import lombok.Getter;
import Company.Product;

import java.util.ArrayList;

public class Inventory {
    private final int capacidad = 50;

    private @Getter ArrayList<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public static Product createProduct(String ID, String name, String description, String price, String amount) throws NumberFormatException, EmptyTextField {
        double priceParse;
        int amountParse;
        priceParse = Double.parseDouble(price);
        amountParse = Integer.parseInt(amount);
        return new Product(ID, name, description, priceParse, amountParse);
    }


    public void setOrAddProduct(Product product) {
        int index;
        try{
            index = searchIndexByID(product);
            getProducts().set(index, product);
        }catch (ResourceNotFound ex){
            getProducts().add(product);
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
