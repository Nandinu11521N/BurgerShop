/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Controller.OrderController;
import Model.OrderDetails;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author nandinusaminda
 */
public class PlaceOrderForm extends JFrame {
        private final JButton btnPlaceOrder;
        private final JButton btnBackTo;
        private final JButton btnCancel;
        
        private final JLabel lblHome;
        
        private final JLabel lblOrderID;
        private final JLabel lblCustomerID;
        private final JLabel lblName;
        private final JLabel lblQuantity;
        private final JLabel lblTotal;
        
        private final JTextField txtOrderID;
        private final JTextField txtCustomerID;
        private final JTextField txtName;
        private final JTextField txtQuantity;
        private final JTextField txtTotal;
        

    public PlaceOrderForm(){
        setTitle("Place Order Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        String orderId = OrderController.getLastOrderID();
        
        lblOrderID = new JLabel("Order ID :");
        lblOrderID.setFont(new Font("", Font.PLAIN, 20));
        lblOrderID.setBounds(50, 200, 100, 30);
        
        txtOrderID = new JTextField(orderId);
        txtOrderID.setBounds(200, 200, 200, 30);
        txtOrderID.setEditable(false);
        
        lblCustomerID = new JLabel("Customer ID :");
        lblCustomerID.setFont(new Font("", Font.PLAIN, 20));
        lblCustomerID.setBounds(50, 300, 150, 30);

        txtCustomerID = new JTextField();
        txtCustomerID.setBounds(200, 300, 200, 30);
        txtCustomerID.addActionListener((ActionEvent e) -> {
            String input1 = txtCustomerID.getText();
            String result1 = OrderController.getNumber(input1);
            if (result1.equals(input1)) {
                System.out.println("Valid phone number: " + input1);
            } else {
                JOptionPane.showMessageDialog(null, result1, "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        });

        lblName = new JLabel("Name :");
        lblName.setFont(new Font("", Font.PLAIN, 20));
        lblName.setBounds(50, 400, 400, 30);

        txtName = new JTextField();
        txtName.setBounds(200, 400, 400, 30);
        txtName.addActionListener((ActionEvent e) -> {
            String input2 = txtName.getText();
            String duplicateName1 = OrderController.checkNumber(input2);
            if (duplicateName1 != null) {
                JOptionPane.showMessageDialog(null, "Duplicate name found: " + duplicateName1, "Duplicate Name", JOptionPane.WARNING_MESSAGE);
            }
        });

        lblQuantity = new JLabel("Quantity :");
        lblQuantity.setFont(new Font("", Font.PLAIN, 20));
        lblQuantity.setBounds(50, 500, 100, 30);

        txtQuantity = new JTextField();
        txtQuantity.setBounds(200, 500, 200, 30);
        txtQuantity.addActionListener((ActionEvent e) -> {
            int burgerQuantity = OrderController.getBurger();
            System.out.println("Burger Quantity: " + burgerQuantity);
        });
        
        lblTotal = new JLabel("NET Total :");
        lblTotal.setFont(new Font("", Font.PLAIN, 20));
        lblTotal.setBounds(1000,800,120,40);

        txtTotal = new JTextField();
        txtTotal.setBounds(1150,800,120,40);
        txtOrderID.setEditable(false);
        
        
        btnPlaceOrder= new JButton("Place Order");
        btnPlaceOrder.setFont(new Font("",Font.PLAIN,20));
        btnPlaceOrder.setBounds(1000,200,300,40);
        btnPlaceOrder.setFocusable(false);
        btnPlaceOrder.addActionListener(evt ->{
            int burgerQuantity = Integer.parseInt(txtQuantity.getText());
            double totalValue = OrderController.getTotal(burgerQuantity);
            txtTotal.setText(String.valueOf(totalValue));
            
            OrderController.extendList();
            int lastIndex = OrderController.orders.size() - 1;
            
            OrderController.orders.get(lastIndex).setOrderIDs(orderId);
            OrderController.orders.get(lastIndex).setNumbers(txtCustomerID.getText());
            OrderController.orders.get(lastIndex).setNames(txtName.getText());
            OrderController.orders.get(lastIndex).setBurgers(Integer.parseInt(txtQuantity.getText()));
            OrderController.orders.get(lastIndex).setTotals(Double.parseDouble(txtTotal.getText()));
            OrderController.orders.get(lastIndex).setOrderStatusArray(OrderDetails.STATUS_PREPARING);
        });
        
        btnBackTo= new JButton("Back To Home Page");
        btnBackTo.setFont(new Font("",Font.PLAIN,20));
        btnBackTo.setBounds(1000,400,300,40);
        btnBackTo.setFocusable(false);
        btnBackTo.addActionListener(evt ->{
            new HomePage();
            
        });
        
        btnCancel= new JButton("Exit");
        btnCancel.setFont(new Font("",Font.PLAIN,20));
        btnCancel.setBounds(1000,600,300,40);
        btnCancel.setFocusable(false);
        btnCancel.addActionListener(evt ->{
            System.exit(0);
        });
        
        lblHome= new JLabel();
        lblHome.setText("PLACE ORDER FORM");
        lblHome.setFont(new Font("",Font.BOLD,40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0,0,900,70);
        
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(255,0,0));
        lblHome.setOpaque(true);
       
        
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
        
        
        add(btnPlaceOrder);
        add(btnBackTo);
        add(btnCancel);
        getContentPane().setBackground(Color.gray);
        setVisible(true);
        
    }
}
