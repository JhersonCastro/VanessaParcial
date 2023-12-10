package IU.Client;

import Company.Transaction;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TransactionPanel {
    public static JScrollPane createTransactionPanel(ArrayList<Transaction> transactions, JLabel dineroGastadoLbl) {
        JPanel panel = new JPanel();
        double dineroGastado = 0;
        panel.setLayout(new GridLayout(transactions.size(), 2));
        for (Transaction transaction : transactions) {
            JLabel productLabel = new JLabel("Producto: " + transaction.getProduct().getName());
            JLabel priceLabel = new JLabel("$ " + transaction.getProduct().getPrice());
            JLabel dateLabel = new JLabel("Fecha: " + transaction.getDate().toString());
            dineroGastado += transaction.getProduct().getPrice();
            panel.add(productLabel);
            panel.add(priceLabel);
            panel.add(dateLabel);
        }
        dineroGastadoLbl.setText(String.valueOf(dineroGastado));
        return new JScrollPane(panel);
    }
}
