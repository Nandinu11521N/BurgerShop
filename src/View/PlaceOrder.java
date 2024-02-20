/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author nandinusaminda
 */
    public class PlaceOrder extends JFrame {
        private JButton btnPlaceOrder;
        private JButton btnBackTo;
        private JButton btnCancel;
        
        private JLabel lblHome;
        private JLabel lblimage;


    public PlaceOrder(){
        setTitle("Place Order");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        btnPlaceOrder= new JButton("Place Order");
        btnPlaceOrder.setFont(new Font("",Font.PLAIN,20));
        btnPlaceOrder.setBounds(1000,200,300,40);
        btnPlaceOrder.setFocusable(false);
        btnPlaceOrder.addActionListener(evt ->{
            new PlaceOrderForm().setVisible(true);
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
        lblHome.setText("PLACE ORDER");
        lblHome.setFont(new Font("",Font.BOLD,40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0,0,900,70);
        
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(255,0,0));
        lblHome.setOpaque(true);
        
        lblimage= new JLabel();
        lblimage.setBounds(0,50,900, 950);
        ImageIcon icon = new ImageIcon("src/img/Screenshot 2024-02-14 at 17.26.11.png");
        lblimage.setIcon(icon);
        add(lblimage, BorderLayout.WEST);
        lblimage.setVisible(true);
        
        add(lblHome);
        add(lblimage);
        
        add(btnPlaceOrder);
        add(btnBackTo);
        add(btnCancel);
        
    }
}