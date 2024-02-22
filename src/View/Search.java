/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author nandinusaminda
 */
public class Search extends JFrame {
    private final JButton btnSearchBest;
    private final JButton btnSearchOrder;
    private final JButton btnSearchCustomer;
    private final JButton btnExit;
    
    private final JLabel lblHome;
    
    public Search(){
        setTitle("Search");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        btnSearchBest= new JButton("Search Best Customer");
        btnSearchBest.setFont(new Font("",Font.PLAIN,20));
        btnSearchBest.setBounds(100,200,300,40);
        btnSearchBest.setFocusable(false);
        btnSearchBest.addActionListener(evt ->{
            new BestCustomer();
            
        });
        
        btnSearchOrder= new JButton("Search Order");
        btnSearchOrder.setFont(new Font("",Font.PLAIN,20));
        btnSearchOrder.setBounds(600,400,300,40);
        btnSearchOrder.setFocusable(false);
        btnSearchOrder.addActionListener(evt ->{
            new SearchOrder();
        });
        
        btnSearchCustomer= new JButton("Search Customer");
        btnSearchCustomer.setFont(new Font("",Font.PLAIN,20));
        btnSearchCustomer.setBounds(1100,600,300,40);
        btnSearchCustomer.setFocusable(false);
        btnSearchCustomer.addActionListener(evt ->{
            new SearchCustomer();
        });
        
        btnExit= new JButton("Back");
        btnExit.setFont(new Font("",Font.PLAIN,20));
        btnExit.setBounds(1300,800,80,40);
        btnExit.setFocusable(false);
        btnExit.addActionListener(evt ->{
            new HomePage();
        });
        
        lblHome= new JLabel();
        lblHome.setText("Search");
        lblHome.setFont(new Font("",Font.BOLD,40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(400,0,700,70);
        
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(255,0,0));
        lblHome.setOpaque(true);
        
        JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("src/img/Screenshot 2024-02-20 at 19.31.36.png");

            Image image = imageIcon.getImage();
            int width = 1450;
            int height = 900;
            g.drawImage(image, 0, 0, width, height, this);
        }
    };
    panel.setBounds(0, 0, 1450, 900);

        add(lblHome);
        
        add(btnSearchBest);
        add(btnSearchOrder);
        add(btnSearchCustomer);
        add(btnExit);
        
        add(panel);
        
    }
}
