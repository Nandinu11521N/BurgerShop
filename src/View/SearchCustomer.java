/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.OrderController;
import static Controller.OrderController.orders;
import Model.OrderDetails;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author nandinusaminda
 */
public class SearchCustomer extends JFrame {
    private final JButton btnCancel;
    private final JLabel lblHome;
    private final JLabel lblHome02;
    private final JLabel lblCustomerID;
    private final JLabel lblName;
    private final JTextField txtCustomerID;
    private final JTextField txtName;
    private final JTable table;

    public SearchCustomer() {
        setTitle("SEARCH CUSTOMER DETAILS");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1100, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);

        lblCustomerID = new JLabel("Customer ID :");
        lblCustomerID.setFont(new Font("", Font.PLAIN, 20));
        lblCustomerID.setBounds(50, 100, 150, 30);
        add(lblCustomerID);

        txtCustomerID = new JTextField();
        txtCustomerID.setBounds(200, 100, 200, 30);
        txtCustomerID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerId = txtCustomerID.getText();
                OrderDetails customer = OrderController.getCustomerById(customerId);
                if (customer != null) {
                    txtName.setText(customer.getNames());
                    updateTableByCustomerID(customerId);
                } else {
                    JOptionPane.showMessageDialog(null, "No data found for the entered customer ID", "No Data Found", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        add(txtCustomerID);

        lblName = new JLabel("Name :");
        lblName.setFont(new Font("", Font.PLAIN, 20));
        lblName.setBounds(50, 200, 150, 30);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(200, 200, 400, 30);
        txtName.setEditable(false);
        add(txtName);

        btnCancel = new JButton("Back");
        btnCancel.setFont(new Font("", Font.PLAIN, 20));
        btnCancel.setBounds(1300, 850, 100, 40);
        btnCancel.setFocusable(false);
        btnCancel.addActionListener(evt -> {
            new HomePage();
        });
        add(btnCancel);

        lblHome = new JLabel();
        lblHome.setText("SEARCH CUSTOMER");
        lblHome.setFont(new Font("", Font.BOLD, 40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0, 0, 1500, 70);
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(255, 0, 0));
        lblHome.setOpaque(true);
        add(lblHome);

        lblHome02 = new JLabel();
        lblHome02.setText("ORDER DETAILS");
        lblHome02.setFont(new Font("", Font.BOLD, 40));
        lblHome02.setForeground(Color.white);
        lblHome02.setBounds(0, 300, 1500, 70);
        lblHome02.setVerticalAlignment(JLabel.CENTER);
        lblHome02.setHorizontalAlignment(JLabel.CENTER);
        lblHome02.setBackground(new Color(255, 0, 0));
        lblHome02.setOpaque(true);
        add(lblHome02);

        String[] columns = {"Order ID", "Quantity", "Total"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0 -> String.class;
                    case 1 -> Integer.class;
                    case 2 -> Double.class;
                    default -> Object.class;
                };
            }
        };
        table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("", Font.PLAIN, 16));
        
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 400, 1000, 400);
        add(scrollPane);
    }

    private void updateTableByCustomerID(String customerId) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (OrderDetails order : orders) {
            if (customerId.equalsIgnoreCase(order.getNumbers())) {
                Object[] rowData = {
                        order.getOrderIDs(),
                        order.getBurgers(),
                        order.getTotals()
                };
                model.addRow(rowData);
            }
        }
    }
}
