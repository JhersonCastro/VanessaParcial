package IU.Client;

import Company.Product;
import Users.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public final class ProductPanel {
    public static JScrollPane createProductPanel(ArrayList<Product> products, Client client, JLabel lblSaldo) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(products.size(), 3));
        for (Product product : products) {
            JLabel nameLabel = new JLabel(product.getName());
            JLabel descriptLabel = new JLabel("Descripcion: " + product.getDescription() + "                  ");
            JLabel amountLabel = new JLabel("\tCantidad: " + product.getAmount());
            JLabel priceLabel = new JLabel("\t$" + product.getPrice());

            JButton buyButton = new JButton("Comprar");
            buyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if((client.getSaldo() - product.getPrice()) >= 0 && (product.getAmount() - 1) >= 0){
                        client.updateSaldo(-product.getPrice());
                        product.updateAmount(-1);
                        client.addTransactions(product);
                        lblSaldo.setText(String.valueOf(client.getSaldo()));
                        amountLabel.setText(String.valueOf(product.getAmount()));
                    }
                }
            });

            panel.add(nameLabel);
            panel.add(descriptLabel);
            panel.add(amountLabel);
            panel.add(priceLabel);
            panel.add(buyButton);
        }
        return new JScrollPane(panel);
    }
}