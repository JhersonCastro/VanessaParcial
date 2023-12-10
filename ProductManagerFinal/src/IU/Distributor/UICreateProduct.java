package IU.Distributor;

import Company.Inventory;
import Company.Product;
import Enums.ID;
import Exceptions.EmptyTextField;
import IU.Client.UIUser;
import Users.Client;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static Company.Inventory.createProduct;

public class UICreateProduct {
    private @Getter @Setter JPanel panel1;
    private JButton Agregar;
    private JTextField txtName;
    private JTextField txtID;
    private JTextArea txtDescripcion;
    private JTextField txtCantidad;
    private JTextField txtPrecio;
    Inventory inventory;
    public UICreateProduct(Inventory inventory) {
        this.inventory = inventory;
        Agregar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Product tmpProduct = createProduct(txtID.getText(), txtName.getText(),
                            txtDescripcion.getText(), txtPrecio.getText(), txtCantidad.getText());
                    inventory.setOrAddProduct(tmpProduct);
                } catch (EmptyTextField ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "EmptyTextField Error", JOptionPane.INFORMATION_MESSAGE);
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "NumberFormatException Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

}
