package InterfacesGraficas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginForm {
    private JPanel panel1;
    private JFormattedTextField formattedTextField1;
    private JPasswordField passwordField1;
    private JButton confirmarButton;
    private JButton button1;
    private JLabel lblCurrentOperation;
    public LoginForm() {
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        SignUpForm signupForm = new SignUpForm();
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
    }

    public JPanel getPanel1(){
        return panel1;
    }
}
