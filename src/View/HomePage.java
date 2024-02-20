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
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author nandinusaminda
 */
public class HomePage extends JFrame {
    
    private final JButton btnPlaceOrder;
    private final JButton btnSearch;
    private final JButton btnViewOrder;
    private final JButton btnUpdateOrder;
    private final JButton btnExit;
    
    private final JLabel lblHome;
    private final JLabel lblimage;
    
    public HomePage(){
        setTitle("Home Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        btnPlaceOrder= new JButton("Place Order");
        btnPlaceOrder.setFont(new Font("",Font.PLAIN,20));
        btnPlaceOrder.setBounds(900,200,300,40);
        btnPlaceOrder.setFocusable(false);
        btnPlaceOrder.addActionListener(evt ->{
            new PlaceOrder();
            
        });
        
        btnSearch= new JButton("Search");
        btnSearch.setFont(new Font("",Font.PLAIN,20));
        btnSearch.setBounds(900,350,300,40);
        btnSearch.setFocusable(false);
        btnSearch.addActionListener(evt ->{
            new Search();
        });
        
        btnViewOrder= new JButton("View Orders");
        btnViewOrder.setFont(new Font("",Font.PLAIN,20));
        btnViewOrder.setBounds(900,500,300,40);
        btnViewOrder.setFocusable(false);
        btnViewOrder.addActionListener(evt ->{
            new ViewOrders();
        });
        
        btnUpdateOrder= new JButton("Update Order Details");
        btnUpdateOrder.setFont(new Font("",Font.PLAIN,20));
        btnUpdateOrder.setBounds(900,650,300,40);
        btnUpdateOrder.setFocusable(false);
        btnUpdateOrder.addActionListener(evt ->{
            new UpdateOrder();
        });
        
        btnExit= new JButton("Exit");
        btnExit.setFont(new Font("",Font.PLAIN,20));
        btnExit.setBounds(1300,800,80,40);
        btnExit.setFocusable(false);
        btnExit.addActionListener(evt ->{
            System.exit(0);
            
        });
        
        lblHome= new JLabel();
        lblHome.setText("WELCOME TO BURGERS");
        lblHome.setFont(new Font("",Font.BOLD,40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0,0,700,70);
        
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(255,0,0));
        lblHome.setOpaque(true);
        
        lblimage= new JLabel();
        lblimage.setBounds(-380,100,1080, 1030);
        ImageIcon icon = new ImageIcon("src/img/Screenshot 2024-02-14 at 16.38.11.png");
        lblimage.setIcon(icon);
        add(lblimage, BorderLayout.WEST);
        lblimage.setVisible(true);
        
        
        add(lblHome);
        add(lblimage);
        
        add(btnPlaceOrder);
        add(btnSearch);
        add(btnViewOrder);
        add(btnUpdateOrder);
        add(btnExit);
        
    }
}
