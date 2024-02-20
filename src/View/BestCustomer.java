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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author nandinusaminda
 */
public class BestCustomer extends JFrame {
    private JButton btnExit;
    
    private JLabel lblHome;
    
    private final JTable table;
    
    public BestCustomer(){
        setTitle("Search");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        btnExit= new JButton("Back");
        btnExit.setFont(new Font("",Font.PLAIN,20));
        btnExit.setBounds(1300,800,80,40);
        btnExit.setFocusable(false);
        btnExit.addActionListener(evt ->{
            new HomePage();
        });
        
        lblHome= new JLabel();
        lblHome.setText("BEST CUSTOMER");
        lblHome.setFont(new Font("",Font.BOLD,40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0,0,1500,70);
        
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(255,0,0));
        lblHome.setOpaque(true);
        
        String[] columns = {"Customer ID", "Name", "Total"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Double.class;
                    default:
                        return Object.class;
                }
            }
        };
        table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("", Font.PLAIN, 20));
        
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 200, 1200, 600);
        add(scrollPane);
        
        List<OrderDetails> customerOrders = new ArrayList<>(orders);
        List<Double> aggregatedTotals = new ArrayList<>();

        for(int i = 0; i < customerOrders.size(); i++){
            aggregatedTotals.add(0.0);
        }

        for(int i = 0; i < customerOrders.size(); i++){
            boolean isUnique = true;
            for(int j = 0; j < i; j++){
                if(customerOrders.get(j).getNames().equals(customerOrders.get(i).getNames())){
                    isUnique = false;
                    break;
                }
            }
            if(isUnique){
                if(customerOrders.get(i).getOrderStatusArray() == OrderDetails.STATUS_PREPARING || customerOrders.get(i).getOrderStatusArray() == OrderDetails.STATUS_DELIVERED){
                    aggregatedTotals.set(i, aggregatedTotals.get(i) + customerOrders.get(i).getTotals());
                }
            }else{
                for(int k = 0; k < i; k++){
                    if(customerOrders.get(k).getNames().equals(customerOrders.get(i).getNames())){
                        if(customerOrders.get(i).getOrderStatusArray() == OrderDetails.STATUS_PREPARING || customerOrders.get(i).getOrderStatusArray() == OrderDetails.STATUS_DELIVERED){
                            aggregatedTotals.set(k, aggregatedTotals.get(k) + customerOrders.get(i).getTotals());
                            break;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < customerOrders.size() - 1; i++){
            for(int j = 0; j < customerOrders.size() - i - 1; j++){
                if(aggregatedTotals.get(j) < aggregatedTotals.get(j + 1)){
                    double tempTotal = aggregatedTotals.get(j);
                    aggregatedTotals.set(j, aggregatedTotals.get(j + 1));
                    aggregatedTotals.set(j + 1, tempTotal);

                    OrderDetails tempOrder = customerOrders.get(j);
                    customerOrders.set(j, customerOrders.get(j + 1));
                    customerOrders.set(j + 1, tempOrder);
                }
            }
        }
        
        for(int i = 0; i < customerOrders.size(); i++){
            Object[] rowData = {
                        customerOrders.get(i).getNumbers(),
			customerOrders.get(i).getNames(),
			aggregatedTotals.get(i)
                };
                model.addRow(rowData);
    
        
            add(lblHome);

            add(btnExit);
        }
    }
}


