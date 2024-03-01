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
public class UpdateOrder extends JFrame {
    private final JButton btnUpdateOrder;
    private final JButton btnBack;
    
    private final JLabel lblHome;
    private final JLabel lblimage;
    
    public UpdateOrder(){
        setTitle("Update");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        btnUpdateOrder= new JButton("Update Order");
        btnUpdateOrder.setFont(new Font("",Font.PLAIN,20));
        btnUpdateOrder.setBounds(1100,800,200,40);
        btnUpdateOrder.setFocusable(false);
        btnUpdateOrder.addActionListener(evt ->{
            new UpdateOrderForm();
        });
        
        btnBack= new JButton("Back");
        btnBack.setFont(new Font("",Font.PLAIN,20));
        btnBack.setBounds(1300,800,80,40);
        btnBack.setFocusable(false);
        btnBack.addActionListener(evt ->{
            new HomePage();
        });
        
        lblHome= new JLabel();
        lblHome.setText("Update Orders");
        lblHome.setFont(new Font("",Font.BOLD,40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0,0,1500,70);
        
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(255,0,0));
        lblHome.setOpaque(true);
        
        lblimage= new JLabel();
        lblimage.setBounds(-100,50,1200, 900);
        ImageIcon icon = new ImageIcon("src/img/Screenshot 2024-02-20 at 19.42.32.png");
        lblimage.setIcon(icon);
        add(lblimage, BorderLayout.WEST);
        lblimage.setVisible(true);
        
        add(lblHome);
        add(lblimage);
        
        add(btnUpdateOrder);
        add(btnBack);
        
    }   
}
