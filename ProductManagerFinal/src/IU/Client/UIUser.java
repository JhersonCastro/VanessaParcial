package IU.Client;

import Company.Inventory;
import Users.Client;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UIUser {
    private @Getter JPanel panel1;
    private JLabel lblUserName;
    private JLabel lblSaldo;
    private JButton verMovimientosButton;
    public UIUser(Client client, Inventory inventory) {
        lblUserName.setText(client.getNombre());
        lblSaldo.setText(String.valueOf(client.getSaldo()));
        panel1.add(ProductPanel.createProductPanel(inventory.getProducts(), client, lblSaldo), BorderLayout.CENTER);
            verMovimientosButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        UIUserMovements userMovements = new UIUserMovements(client);
                        JDialog dialog = new JDialog();
                        dialog.setTitle("Formulario");
                        dialog.setContentPane(userMovements.getPanel1());
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

}
