/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nandinusaminda
 */
public class OrderDetails {

    private String numbers;
    private String names;
    private String orderIDs;
    private int burgers;
    private int orderStatusArray;
    private double totals;

    public static final int STATUS_PREPARING = 0;
    public static final int STATUS_DELIVERED = 1;
    public static final int STATUS_CANCEL = 2;

    public OrderDetails() {
        
    }

    public OrderDetails(String numbers, String names, String orderIDs, int burgers, int orderStatusArray, double totals){
        this.numbers = numbers;
        this.names = names;
        this.orderIDs = orderIDs;
        this.burgers = burgers;
        this.orderStatusArray = orderStatusArray;
        this.totals = totals;
    }

    

    public String getNumbers(){
        return numbers;
    }

    public String getNames(){
        return names;
    }

    public String getOrderIDs(){
        return orderIDs;
    }

    public int getBurgers(){
        return burgers;
    }

    public int getOrderStatusArray(){
        return orderStatusArray;
    }

    public double getTotals(){
        return totals;
    }

    public void setNumbers(String numbers){
        this.numbers = numbers;
    }

    public void setNames(String names){
        this.names = names;
    }

    public void setOrderIDs(String orderIDs){
        this.orderIDs = orderIDs;
    }

    public void setBurgers(int burgers){
        this.burgers = burgers;
    }

    public void setOrderStatusArray(int orderStatusArray){
        this.orderStatusArray = orderStatusArray;
    }

    public void setTotals(double totals){
        this.totals = totals;
    }
}
