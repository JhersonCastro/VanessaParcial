package Company;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Product implements Serializable {
    @Setter @Getter
    private String ID, name, description;
    @Setter @Getter
    private double price;
    @Setter @Getter
    private int amount;
    @Setter @Getter
    private Inventory almacen;
    public void updateAmount(int amount){
        this.amount += amount;
    }
    public Product(String ID, String name, String description, double price, int amount){
             this.ID = ID;
             this.name = name;
             this.description = description;
             this.price = price;
             this.amount = amount;
         }
}
