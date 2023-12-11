import Company.Inventory;
import Database.Database;
import Database.Gestion;
import Enums.ID;
import IU.LoginForm;
import Users.Distributor;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String nombreArchivoInventory = "Inventory.ser", nombreArchivoDatabase = "Database.ser";
        Gestion gestion = new Gestion();
        Database data = (Database) gestion.cargarDesdeArchivo(nombreArchivoDatabase, Gestion.TIPODECLASE.DATABASE);
        Inventory inventory = (Inventory) gestion.cargarDesdeArchivo(nombreArchivoInventory, Gestion.TIPODECLASE.INVENTORY);
        Distributor distributor1 = new Distributor("", "", "admin@admin.com", "[A, d, m, i, n, 1, 2, 3, 4, 5]", ID.DISTRIBUIDORA_ID);
        data.getUsers().add(distributor1);

        /*
        Inventory inventory2 = new Inventory();
        Distributor distributor2 = new Distributor("", "", "admin2@admin.com", "[A, d, m, i, n, 1, 2, 3, 4, 5]", ID.DISTRIBUIDORA_ID);

        data.getUsers().add(distributor2);

        inventory.addDistributor(distributor1);
        inventory.addDistributor(distributor2);

        inventory2.addDistributor(distributor2);
        */

        SwingUtilities.invokeLater(() -> {
            LoginForm loginForm = new LoginForm(data, inventory);
            JDialog dialog = new JDialog();
            dialog.setTitle("Iniciar sesion");
            dialog.setContentPane(loginForm.getPanel1());
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.pack();
            dialog.setModal(true); // Establecer el diálogo como modal
            dialog.setVisible(true);

            // El código aquí no se ejecutará hasta que el diálogo se cierre
            System.out.println("El diálogo se ha cerrado.");

            gestion.guardarEnArchivo(nombreArchivoInventory, inventory);
            gestion.guardarEnArchivo(nombreArchivoDatabase, data);
        });
    }
}