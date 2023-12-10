package IU;



import Database.Database;
import Enums.ID;
import Exceptions.EmptyTextField;
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
                    database.register(txtNombre.getText(), txtIdentificacion.getText(), txtEmail.getText(), Arrays.toString(txtPassword.getPassword()), ID.values()[comboID.getSelectedIndex()]);
                } catch (EmptyTextField ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "EmptyTextField Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private JButton registrarseButton;
    private JButton salirButton;
    private JFormattedTextField txtNombre;
    private JComboBox comboID;
    private JFormattedTextField txtIdentificacion;
    private JFormattedTextField txtEmail;
    private JPasswordField txtPassword;
    private JFormattedTextField txtReferido;
    private JPanel panel2;

}
