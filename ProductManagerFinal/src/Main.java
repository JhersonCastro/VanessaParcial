import Company.Inventory;
import Database.Database;
import Enums.ID;
import InterfacesGraficas.Client.UIUser;
import InterfacesGraficas.Distributor.UICreateProduct;
import InterfacesGraficas.LoginForm;
import Users.Client;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Database data = new Database();
        Inventory inventory = new Inventory();
        SwingUtilities.invokeLater(() -> {
            UICreateProduct loginForm = new UICreateProduct(inventory);
            JDialog dialog = new JDialog();
            dialog.setTitle("Formulario");
            dialog.setContentPane(loginForm.getPanel1());
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.pack();
            dialog.setModal(true); // Establecer el diálogo como modal
            dialog.setVisible(true);

            // El código aquí no se ejecutará hasta que el diálogo se cierre
            System.out.println("El diálogo se ha cerrado.");

        });
    }
}

