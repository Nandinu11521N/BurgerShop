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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author nandinusaminda
 */
public class UpdateOrderForm extends JFrame {
    private final JButton btnCancel;
    private final JButton btnUpdate;
    
    private final JLabel lblHome;
    
    JFrame frame = new JFrame("Dropdown Example");
    
    
    private final JLabel lblOrderID;
    private final JLabel lblCustomerID;
    private final JLabel lblName;
    private final JLabel lblQuantity;
    private final JLabel lblTotal;
    private final JLabel lblStatus;
    
    private final JTextField txtOrderID;
    private final JTextField txtCustomerID;
    private final JTextField txtName;
    private final JTextField txtQuantity;
    private final JTextField txtTotal;
    
    private final JComboBox<String> comboBox;
    
    public UpdateOrderForm(){
        setTitle("Update Order Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        lblStatus = new JLabel("Order Status :");
        lblStatus.setFont(new Font("", Font.PLAIN, 20));
        lblStatus.setBounds(50, 200, 150, 30);
        
        lblOrderID = new JLabel("Order ID :");
        lblOrderID.setFont(new Font("", Font.PLAIN, 20));
        lblOrderID.setBounds(100, 300, 150, 30);

        txtOrderID = new JTextField();
        txtOrderID.setBounds(250, 300, 200, 30);
        txtOrderID.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String orderId = txtOrderID.getText();

        OrderDetails order = OrderController.getOrderById(orderId);

        if (order != null) {
            txtCustomerID.setText(order.getNumbers()); 
            txtName.setText(order.getNames()); 
            txtQuantity.setEditable(true); 
            txtQuantity.requestFocus(); 
            txtTotal.setText(String.valueOf(order.getTotals())); 
            txtTotal.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(null, "No data found for the entered order ID", "No Data Found", JOptionPane.INFORMATION_MESSAGE);
        }
    }
});
        
        lblCustomerID = new JLabel("Customer ID :");
        lblCustomerID.setFont(new Font("", Font.PLAIN, 20));
        lblCustomerID.setBounds(100, 400, 150, 30);

        txtCustomerID = new JTextField();
        txtCustomerID.setBounds(250, 400, 200, 30);
        txtCustomerID.setEditable(false);

        lblName = new JLabel("Name :");
        lblName.setFont(new Font("", Font.PLAIN, 20));
        lblName.setBounds(100, 500, 400, 30);

        txtName = new JTextField();
        txtName.setBounds(250, 500, 400, 30);
        txtName.setEditable(false);

        lblQuantity = new JLabel("Quantity :");
        lblQuantity.setFont(new Font("", Font.PLAIN, 20));
        lblQuantity.setBounds(100, 600, 100, 30);

        txtQuantity= new JTextField();
        txtQuantity.setBounds(250, 600, 200, 30);
        txtQuantity.setEditable(false);
        
        lblTotal = new JLabel("Total :");
        lblTotal.setFont(new Font("", Font.PLAIN, 20));
        lblTotal.setBounds(100, 700, 100, 30);

        txtTotal = new JTextField();
        txtTotal.setBounds(250, 700, 200, 30);
        txtTotal.setEditable(false);
        
        btnCancel= new JButton("Back");
        btnCancel.setFont(new Font("",Font.PLAIN,20));
        btnCancel.setBounds(1300,850,80,40);
        btnCancel.setFocusable(false);
        btnCancel.addActionListener(evt ->{
            new HomePage();
        });
        
        btnUpdate= new JButton("Update Order");
        btnUpdate.setFont(new Font("",Font.PLAIN,20));
        btnUpdate.setBounds(1100,850,200,40);
        btnUpdate.setFocusable(false);
        btnUpdate.addActionListener(evt ->{
        String orderId = txtOrderID.getText();
        String customerId = txtCustomerID.getText();
        String name = txtName.getText();
        int quantity = Integer.parseInt(txtQuantity.getText()); 
        int burgerQuantity = Integer.parseInt(txtQuantity.getText());
        double totalValue = OrderController.getTotal(burgerQuantity);

        OrderDetails order = OrderController.getOrderById(orderId);
        if (order != null) {
            order.setNumbers(customerId);
            order.setNames(name);
            order.setBurgers(quantity);
            order.setTotals(totalValue);

            JOptionPane.showMessageDialog(null, "Order updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

            txtOrderID.setText("");
            txtCustomerID.setText("");
            txtName.setText("");
            txtQuantity.setText("");
            txtTotal.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid or not found order ID", "Error", JOptionPane.ERROR_MESSAGE);
        }

    });
        
        lblHome= new JLabel();
        lblHome.setText("UPDATE ORDER");
        lblHome.setFont(new Font("",Font.BOLD,40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0,0,1500,70);
        
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(255,0,0));
        lblHome.setOpaque(true);
        
        comboBox = new JComboBox<>();
        comboBox.addItem("Processing....");
        comboBox.addItem("Delivered....");
        comboBox.addItem("Canceled....");
        comboBox.setBounds(250, 205, 200, 30);
        comboBox.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String selectedStatus = (String) comboBox.getSelectedItem();
        String orderId = txtOrderID.getText();

        int status = OrderController.findOrderIndex(orderId);
        
        if(OrderDetails.STATUS_DELIVERED == orders.get(status).getOrderStatusArray() || OrderDetails.STATUS_CANCEL == orders.get(status).getOrderStatusArray()){
            JOptionPane.showMessageDialog(null, "Cannot update status, alreday Delivered or Canceled", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int index = -1;
       
        if (selectedStatus.equals("Processing....")) {
            status = OrderDetails.STATUS_PREPARING;
        } else if (selectedStatus.equals("Delivered....")) {
            status = OrderDetails.STATUS_DELIVERED;
        } else if (selectedStatus.equals("Canceled....")) {
            status = OrderDetails.STATUS_CANCEL;
        }
        
        OrderDetails order = OrderController.getOrderById(orderId);
        if (order != null) {
            order.setOrderStatusArray(status);
            JOptionPane.showMessageDialog(null, "Order updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid or not found order ID", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});
        
        
        add(lblHome);
       
        add(lblOrderID);
        add(txtOrderID);
        add(lblCustomerID);
        add(txtCustomerID);
        add(lblName);
        add(txtName);
        add(lblQuantity);
        add(txtQuantity);
        add(lblTotal);
        add(txtTotal);
        add(lblStatus);
        
        add(btnCancel);
        add(btnUpdate);
        
        add(comboBox);
        
        
    }
}
