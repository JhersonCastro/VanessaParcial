package Users;

import Enums.ID;

public class Distributor extends People{
    public Distributor(String nombre, String identificacion, String email, String password, ID TipoDeId) {
        super(nombre, identificacion, email, password, TipoDeId);
    }
    public void addInventory(Inventory inventory){
        inventories.add(inventory);
    }
    @Override
    public String displayInfo() {
        return super.toString()
                + "Distributor{" +
                "inventory=" + inventories +
                '}';
    }




    @Override
    public void login(Inventory inventory) {
        UICreateProduct createProduct = new UICreateProduct(inventory);
    }

    @Override
    public void updateProfile(String name, String email) {

    }
}
