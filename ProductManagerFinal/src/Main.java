import Company.Inventory;
import Database.Database;
import Enums.ID;
import IU.LoginForm;
import Users.Distributor;
import Users.People;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Database data = new Database();
        Inventory inventory = new Inventory();
        People people = new Distributor("","","admin@admin.com","[A, d, m, i, n, 1, 2, 3, 4, 5]", ID.DISTRIBUIDORA_ID);
        data.getUsers().add(people);
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

        });
    }
}

