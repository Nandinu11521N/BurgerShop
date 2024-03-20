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
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author nandinusaminda
 */
public class SearchOrder extends JFrame {
    private final JButton btnCancel;
    
    private final JLabel lblHome;    
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
    private final JTextField txtStatus;
    
    public SearchOrder(){
        setTitle("SEARCH ORDER DETAILS");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        lblOrderID = new JLabel("Enter Order ID :");
        lblOrderID.setFont(new Font("", Font.PLAIN, 20));
        lblOrderID.setBounds(50, 300, 150, 30);

        txtOrderID = new JTextField();
        txtOrderID.setBounds(200, 300, 200, 30);
        txtOrderID.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String orderId = txtOrderID.getText();

        OrderDetails order = OrderController.getOrderById(orderId);

        if (order != null) {
            txtCustomerID.setText(order.getNumbers()); 
            txtName.setText(order.getNames());
            txtQuantity.setText(String.valueOf(order.getBurgers()));
            txtQuantity.setEditable(false);
            txtTotal.setText(String.valueOf(order.getTotals()));
            txtTotal.setEditable(false);            
            int status = order.getOrderStatusArray();
            switch (status) {
                case 0 -> txtStatus.setText("PREPARING.....");
                case 1 -> txtStatus.setText("DELIVERED.....");
                default -> txtStatus.setText("CANCELED.....");
            }
            txtStatus.setEditable(false);
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

        txtQuantity = new JTextField();
        txtQuantity.setBounds(250, 600, 200, 30);
        txtQuantity.setEditable(false);
        
        lblTotal = new JLabel("Total :");
        lblTotal.setFont(new Font("", Font.PLAIN, 20));
        lblTotal.setBounds(100, 700, 100, 30);

        txtTotal = new JTextField();
        txtTotal.setBounds(250, 700, 200, 30);
        txtTotal.setEditable(false);
        
        lblStatus = new JLabel("Status :");
        lblStatus.setFont(new Font("", Font.PLAIN, 20));
        lblStatus.setBounds(100, 800, 100, 30);

        txtStatus = new JTextField();
        txtStatus.setBounds(250, 800, 200, 30);
        txtStatus.setEditable(false);
        
        btnCancel= new JButton("Back");
        btnCancel.setFont(new Font("",Font.PLAIN,20));
        btnCancel.setBounds(1300,800,80,40);
        btnCancel.setFocusable(false);
        btnCancel.addActionListener(evt ->{
            new HomePage();
        });
        
        lblHome= new JLabel();
        lblHome.setText("SEARCH ORDER DETAILS");
        lblHome.setFont(new Font("",Font.BOLD,40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0,0,1500,70);
        
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
        add(lblStatus);
        add(txtStatus);       
        add(btnCancel);
        
    }
}
