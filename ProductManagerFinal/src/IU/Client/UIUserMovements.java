package IU.Client;

import Users.Client;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class UIUserMovements {
    private @Getter JPanel panel1;
    private JLabel saldoGastado;
    private JLabel lblUsername;

    public UIUserMovements(Client client){
        lblUsername.setText(client.getNombre());
        panel1.add(TransactionPanel.createTransactionPanel(client.getTransactions(), saldoGastado), BorderLayout.CENTER);
    }
}
