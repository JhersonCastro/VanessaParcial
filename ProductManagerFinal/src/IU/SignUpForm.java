package IU;



import Database.*;
import Enums.ID;
import Exceptions.EmptyTextField;
import Exceptions.ResourceNotFound;
import Users.Client;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class SignUpForm {

    @Getter
    private JPanel panel1;

    public SignUpForm(Database database) {
        registrarseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Client newClient =  database.register(txtNombre.getText(), txtIdentificacion.getText(), txtEmail.getText(), Arrays.toString(txtPassword.getPassword()), ID.values()[comboID.getSelectedIndex()]);
                    if(!txtReferido.getText().isEmpty()){
                        String txt = txtReferido.getText();
                        Client client = CheckUser.searchClientById(txt, database);
                        if(client != null)
                            database.getSystemRewards().reward(client, newClient);
                    }
                } catch (EmptyTextField ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "EmptyTextField Error", JOptionPane.INFORMATION_MESSAGE);
                } catch (ResourceNotFound ex) {
                    JOptionPane.showMessageDialog(null, "No se encontro el usuario para referir", "EmptyTextField Error", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        });
    }

    private JButton registrarseButton;
    private JFormattedTextField txtNombre;
    private JComboBox comboID;
    private JFormattedTextField txtIdentificacion;
    private JFormattedTextField txtEmail;
    private JPasswordField txtPassword;
    private JFormattedTextField txtReferido;

}
