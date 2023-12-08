import InterfacesGraficas.LoginForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginForm loginForm = new LoginForm();
                JDialog dialog = new JDialog();
                dialog.setTitle("Formulario");
                dialog.setContentPane(loginForm.getPanel1());
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

