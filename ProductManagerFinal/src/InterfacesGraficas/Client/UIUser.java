package InterfacesGraficas.Client;

import Company.Inventory;
import Database.Database;
import Users.Client;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class UIUser {
    private @Getter JPanel panel1;
    private JLabel lblUserName;
    private JLabel lblSaldo;
    private JButton salirButton;
    private JPanel ProductView;
    private JButton salimButton;
    public UIUser(Client client, Inventory inventory) {
        lblUserName.setText(client.getNombre());
        lblSaldo.setText(String.valueOf(client.getSaldo()));
        panel1.add(ProductPanel.createProductPanel(inventory.getProducts(), client, lblSaldo), BorderLayout.CENTER);
    }

}
