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
public class ViewOrders extends JFrame {
    private final JButton btnDeliveredOrders;
    private final JButton btnPreparingOrders;
    private final JButton btnCanceledOrders;
    private final JButton btnExit;
    
    private final JLabel lblHome;
    private final JLabel lblimage;
    
    public ViewOrders(){
        setTitle("View");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        btnDeliveredOrders= new JButton("Delivered Orders");
        btnDeliveredOrders.setFont(new Font("",Font.PLAIN,20));
        btnDeliveredOrders.setBounds(1000,200,300,40);
        btnDeliveredOrders.setFocusable(false);
        btnDeliveredOrders.addActionListener(evt ->{
            new DeliveredOrders();
        });
        
        btnPreparingOrders= new JButton("Processing Orders");
        btnPreparingOrders.setFont(new Font("",Font.PLAIN,20));
        btnPreparingOrders.setBounds(1000,400,300,40);
        btnPreparingOrders.setFocusable(false);
        btnPreparingOrders.addActionListener(evt ->{
            new ProcessingOrders();
        });
        
        btnCanceledOrders= new JButton("Canceled Orders");
        btnCanceledOrders.setFont(new Font("",Font.PLAIN,20));
        btnCanceledOrders.setBounds(1000,600,300,40);
        btnCanceledOrders.setFocusable(false);
        btnCanceledOrders.addActionListener(evt ->{
            new CanceledOrders();
        });
        
        btnExit= new JButton("Back");
        btnExit.setFont(new Font("",Font.PLAIN,20));
        btnExit.setBounds(1300,800,80,40);
        btnExit.setFocusable(false);
        btnExit.addActionListener(evt ->{
            new HomePage();
        });
        
        lblHome= new JLabel();
        lblHome.setText("View Orders");
        lblHome.setFont(new Font("",Font.BOLD,40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0,0,900,70);
        
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(255,0,0));
        lblHome.setOpaque(true);
        
        lblimage= new JLabel();
        lblimage.setBounds(0,50,900, 950);
        ImageIcon icon = new ImageIcon("src/img/Screenshot 2024-02-14 at 17.42.14.png");
        lblimage.setIcon(icon);
        add(lblimage, BorderLayout.WEST);
        lblimage.setVisible(true);
        
        add(lblHome);
        add(lblimage);        
        add(btnDeliveredOrders);
        add(btnPreparingOrders);
        add(btnCanceledOrders);
        add(btnExit);
        
    }
}
