/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import static Controller.OrderController.orders;
import Model.OrderDetails;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author nandinusaminda
 */
public class ProcessingOrders extends JFrame {
    private final JButton btnCancel;
    private final JLabel lblHome ;

    public ProcessingOrders(){
        setTitle("Processing Orders");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        btnCancel= new JButton("Back");
        btnCancel.setFont(new Font("",Font.PLAIN,20));
        btnCancel.setBounds(650, 500, 100, 40);
        btnCancel.setFocusable(false);
        btnCancel.addActionListener(evt ->{
            new HomePage();
        });

        lblHome= new JLabel();
        lblHome.setText("PROCESSING ORDERS......");
        lblHome.setFont(new Font("",Font.BOLD,40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0,0,800,70);
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(255,0,0));
        lblHome.setOpaque(true);
        
        List<OrderDetails> processingOrders = new ArrayList<>();
        for (OrderDetails order : orders) {
        if (order.getOrderStatusArray() == OrderDetails.STATUS_PREPARING) {
            processingOrders.add(order);
        }
    }

        String[] columns = {"Order ID", "Customer ID", "Name", "Order QTY", "Total"};

        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                    case 1:
                    case 2:
                        return String.class;
                    case 3:
                        return Integer.class;
                    case 4:
                        return Double.class;
                    default:
                        return Object.class;
                }
            }
        };

        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("", Font.PLAIN, 16));
        
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 100));
        
        for (OrderDetails order : processingOrders) {
        Object[] rowData = {
            order.getOrderIDs(),
            order.getNumbers(),
            order.getNames(),
            order.getBurgers(),
            order.getTotals()
        };
        model.addRow(rowData);
    }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 100, 700, 350); 

        add(lblHome);
        add(scrollPane);
        add(btnCancel);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
    }
}
