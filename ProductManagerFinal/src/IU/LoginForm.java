package IU;

import Company.Inventory;
import Database.Database;
import IU.Client.UIUser;
import IU.Distributor.UICreateProduct;
import Users.Client;
import Users.People;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class LoginForm {
    @Getter
    private JPanel panel1;
    private JFormattedTextField txtEmail;
    private JPasswordField txtPassword;
    private JButton confirmarButton;
    private JButton button1;
    private JLabel lblCurrentOperation;

    public LoginForm(Database database, Inventory inventory) {
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        SignUpForm signupForm = new SignUpForm(database);
                        JDialog dialog = new JDialog();
                        dialog.setTitle("Formulario");
                        dialog.setContentPane(signupForm.getPanel1());
                        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        dialog.pack();
                        dialog.setModal(true); // Establecer el diálogo como modal
                        dialog.setVisible(true);

                        // El código aquí no se ejecutará hasta que el diálogo se cierre
                        System.out.println("El diálogo se ha cerrado.");
                    }
                });
            }
        });
        confirmarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                People people = database.logIn(txtEmail.getText(), Arrays.toString(txtPassword.getPassword()));
                if(people != null){

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {

                        JDialog dialog = new JDialog();
                        dialog.setTitle("Login");
                        if(people.getClass().equals(Client.class)){
                            UIUser user = new UIUser((Client) people, inventory);
                            dialog.setContentPane(user.getPanel1());
                        }else {
                            UICreateProduct user = new UICreateProduct(inventory);
                            dialog.setContentPane(user.getPanel1());
                        }
                        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        dialog.pack();
                        dialog.setModal(true); // Establecer el diálogo como modal
                        dialog.setVisible(true);

                        // El código aquí no se ejecutará hasta que el diálogo se cierre
                        System.out.println("El diálogo se ha cerrado.");
                    }
                });
                }
            }
        });
    }

}
