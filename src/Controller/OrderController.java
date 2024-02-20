/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.OrderDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nandinusaminda
 */
public class OrderController {
    static Scanner input = new Scanner(System.in);
    public static List<OrderDetails> orders;

    static{
        orders = new ArrayList<>();
    }

    public static void extendList(){
        OrderDetails newOrder = new OrderDetails();
        orders.add(newOrder);
    }

    public static void startSystem(){
			A :while(true){	
			System.out.println("\n\n\n\n");	
			System.out.println("		  ||=================================================================================================||\n\n");
			System.out.println("			.__  ___ ___                                     __________                                  ");                  
			System.out.println("			|__|/   |   \\ __ __  ____    ___________ ___.__. \\______   \\__ _________  ____   ___________ ");  
			System.out.println("			|  /    ~    \\  |  \\/    \\  / ___\\_  __ <   |  |  |    |  _/  |  \\_  __ \\/ ___\\_/ __ \\_  __ \\"); 
			System.out.println("			|  \\    Y    /  |  /   |  \\/ /_/  >  | \\/\\___  |  |    |   \\  |  /|  | \\/ /_/  >  ___/|  | \\/");
			System.out.println("			|__|\\___|_  /|____/|___|  /\\___  /|__|   / ____|  |______  /____/ |__|  \\___  / \\___  >__|   ");
			System.out.println("			          \\/            \\//_____/        \\/              \\/            /_____/      \\/        \n\n\n");
			System.out.println("		  ||================================================================================================||\n\n\n\n    ");
			System.out.printf("                                %-21s                          %-21s\n\n\n\n\n","[1] PLACE ORDER","[2] SEARCH BEST CUSTOMER");				//[1] Place Order									[2] Search Best Customer			\n\n\n");
			System.out.printf("                                %-21s                          %-21s\n\n\n\n\n","[3] SEARCH ORDER","[4] SEARCH CUSTOMER");
			System.out.printf("                                %-21s                          %-21s\n\n\n\n\n","[5] VIEW ORDERS","[6] UPDATE ORDER DETAILS");
			System.out.printf("                                %-21s                                                                \n\n\n\n\n","[7] EXIT");
			systemController();
		}
	}
	
	public static void systemController(){
		System.out.print("Enter an option to continue -> ");
		char num = input.next().charAt(0);
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.println("\n\n\n");
		
		switch(num){
			case '1': placeOrder();
					break;
			case '2': bestCustomer();
					break;
			case '3': searchOrder();
					break;
			case '4': searchCustomer();
					break;
			case '5': viewOrders();
					break;
			case '6': updateOrder();
					break;
			case '7': System.out.println("\n\n\n\n"); 
					  System.out.println("			___________.__                   __     _____.___.              ._. _________                           _____                .__                        ");   
					  System.out.println("			\\__    ___/|  |__ _____    ____ |  | __ \\__  |   | ____  __ __  | | \\_   ___ \\  ____   _____   ____    /  _  \\    _________  |__| ____                  "); 
					  System.out.println("			   |    |   |  |  \\__  \\  /    \\|  |/ /  /   |   |/  _ \\|  |  \\ | | /    \\  \\/ /  _ \\ /     \\_/ __ \\  /  /_\\  \\  / ___\\__  \\ |  |/    \\                 ");
					  System.out.println("			   |    |   |   Y  \\/ __ \\|   |  \\   <   \\____   (  <_> )  |  /  \\| \\     \\___(  <_> )  Y Y  \\ ___/  /    |    \\/ /_/  > __ \\|  |   |  \\                ");  
					  System.out.println("			   |____|   |___|  (____  /___|  /__|_\\  / ______|\\____/|____/   __  \\______  /\\____/|__|_|  /\\___ > \\____|__  /\\___  (____  /__|___|  / /\\  /\\  /\\  /\\ ");  
					  System.out.println("			                \\/     \\/     \\/     \\/  \\/                      \\/         \\/             \\/     \\/          \\//_____/    \\/        \\/  \\/  \\/  \\/  \\/ \n\n\n ");
					  System.exit(0);
		    default :invalidController();
	   }
   }
   
   public static void invalidController(){			   
	   System.out.println("\n\n\n\n				Invalid Input....Please Try Again......\n\n\n");
   }
   
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
		System.out.flush();
    }
    
   public static void placeOrder(){
	   System.out.println("			||=====================================================================||\n\n");
	   System.out.println("			__________.__                        ________            .___            ");   
	   System.out.println("			\\______   \\  | _____    ____  ____   \\_____  \\_______  __| _/___________ "); 
	   System.out.println("			 |     ___/  | \\__  \\ _/ ___\\/ __ \\   /   |   \\_  __ \\/ __ |/ __ \\_  __ \\");
	   System.out.println("			 |    |   |  |__/ __ \\  \\__\\  ___/  /    |    \\  | \\/ /_/ \\  ___/|  | \\/");  
	   System.out.println("			 |____|   |____(____  /\\___  >___  > \\_______  /__|  \\____ |\\___  >__|   ");  
	   System.out.println("			                    \\/     \\/    \\/          \\/           \\/    \\/       \n\n\n ");
           System.out.println("			||=====================================================================||\n\n\n\n\n\n");
           String orderId = getLastOrderID();
           System.out.println("						Order ID: " + orderId + "\n\n\n\n\n");
           //String number = getNumber();

          
           //String name = checkNumber();

           System.out.println("\n\n\n\n\n\n");
           int burgerQuantity = getBurger();
           System.out.println("\n\n\n\n\n\n");
           double totalValue = getTotal(burgerQuantity);
           System.out.println("    Total Value :- "+totalValue);
           System.out.println("\n\n\n\n");

        do{
           System.out.print("			Are You Confirm Order (y/n) :- ");
           String yesOrNo = input.next();

           if(yesOrNo.equals("y")){
               clearScreen();
               extendList();
               int lastIndex = orders.size() - 1;

               orders.get(lastIndex).setOrderIDs(orderId);
               //orders.get(lastIndex).setNumbers(number);
               //orders.get(lastIndex).setNames(name);
               //orders.get(lastIndex).setBurgers(burgerQuantity);
               //orders.get(lastIndex).setTotals(totalValue);
               orders.get(lastIndex).setOrderStatusArray(OrderDetails.STATUS_PREPARING);

               System.out.println("						Your order has been entered into the system successfully...\n\n\n");
               System.out.println("\n\n\n\n\n");

               System.out.print("Do You Want To Place Another Order (y/n): ");
               String yesOrNo2 = input.next();

               if(yesOrNo2.equals("y")){
                   System.out.println();
                   clearScreen();
                   placeOrder();
               }else if(yesOrNo2.equals("n")){
                   clearScreen();
                   startSystem();
               }else{
                   clearScreen();
                   System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
                   System.out.println("\n\n\n");
               }
           }else if(yesOrNo.equals("n")){
               clearScreen();
               placeOrder();
           }else{
                clearScreen();
                System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
                System.out.println("\n\n\n");
            }
       }while(true);
   }
    public static String getNumber(String input){
        if (input.startsWith("0") && input.length() == 10) {
            return input; // Valid phone number
        } else {
            return "Invalid phone number. Please enter a 10-digit number starting with '0'";
        }
    }
   
   public static String checkNumber(String name) {
    for (OrderDetails order : orders) {
        String orderName = order.getNames();
        if (name.equalsIgnoreCase(orderName)) {
            return orderName; // Return the duplicate name if found
        }
    }
    return null; // Return null if no duplicate name is found
}
    
    public static void bestCustomer(){
		System.out.println("			||=====================================================================================================================================||\n\n");					
	    System.out.println("			  _________                           .__      __________                 __    _________                 __                               ");   
		System.out.println("			 /   _____/ ____ _____ _______  ____  |  |__   \\______   \\ ____   _______/  |_  \\_   ___ \\ __ __  _______/  |_  ____   _____   ___________ "); 
		System.out.println("			 \\_____  \\_/ __ \\__  \\ _  __ \\_/ ___\\ |  |  \\   |    |  _// __ \\ /  ___/\\   __\\ /    \\  \\/|  |  \\/  ___/\\   __\\/  _ \\ /     \\_/ __ \\_  __ \\");
	    System.out.println("			 /        \\  ___/ / __ \\|  | \\/\\  \\___|   Y  \\  |    |   \\  ___/ \\___ \\  |  |   \\     \\___|  |  /\\___ \\  |  | (  <_> )  Y Y  \\  ___/|  | \\/");  
		System.out.println("			/_______  /\\___  >____  /__|    \\___  >___|  /  |______  /\\___  >____  > |__|    \\______  /____//____  > |__|  \\____/|__|_|  /\\___  >__|   ");  
		System.out.println("			        \\/     \\/     \\/            \\/     \\/          \\/     \\/     \\/                 \\/           \\/                    \\/     \\/       \n\n\n ");
		System.out.println("			||=====================================================================================================================================||\n\n\n\n\n\n");

        System.out.println("	|----------------------------------------------------------------------------------------------------|\n");
		System.out.println("		Customer ID				Name				Total		\n");
		System.out.println("	|----------------------------------------------------------------------------------------------------|");
		System.out.println("	|----------------------------------------------------------------------------------------------------|\n");

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
            System.out.printf("                %-35s %-35s %-20.2f%n",
			customerOrders.get(i).getNumbers(),
			customerOrders.get(i).getNames(),
			aggregatedTotals.get(i));
            System.out.println("        |----------------------------------------------------------------------------------------------------|\n");
        }

        while(true){
            System.out.print("            Do You Want To Go Back To Main Menu (y/n) ? ");
            String yesOrNo = input.next();
            if (yesOrNo.equals("y")){
                clearScreen();
                startSystem();
                System.out.println("\n\n\n\n\n");
            }else if(yesOrNo.equals("n")){
                clearScreen();
                bestCustomer();
                System.out.println("\n\n\n\n\n");
            }else{
                clearScreen();
                System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
                System.out.println("\n\n\n");
            }
        }
    }
    
    public static void searchOrder(){
		System.out.println("			||==========================================================================================||\n\n");
		System.out.println("			   _________                           .__      ________            .___            ");   
		System.out.println("			  /   _____/ ____ _____ _______   ____ |  |__   \\_____  \\_______  __| _/___________ "); 
		System.out.println("			  \\_____  \\_/ __ \\__  \\_  __ \\_/ ___\\|  |  \\   /   |   \\_  __ \\/ __ |/ __ \\_  __ \\");
		System.out.println("			  /        \\  ___/ / __ \\|  | \\/\\  \\___|   Y  \\ /    |    \\  | \\/ /_/ \\  ___/|  | \\/");  
		System.out.println("			/_______  /\\___  >____  /__|    \\___  >___|  / \\_______  /__|  \\____ |\\___  >__|   ");  
		System.out.println("			        \\/     \\/     \\/            \\/     \\/          \\/           \\/    \\/       \n\n\n ");
		System.out.println("			||==========================================================================================||\n\n\n\n\n\n");
		System.out.print("Enter Order ID - ");
        String sOrder = input.next();
    
		int index = findOrderIndex(sOrder);

		if(index != -1){
			String statusString;
			String num = orders.get(index).getNumbers();
			String name = orders.get(index).getNames();
			int burger = orders.get(index).getBurgers();
			double total = orders.get(index).getTotals();

			if(orders.get(index).getOrderStatusArray() == OrderDetails.STATUS_PREPARING){
				statusString = "PREPARING";
			}else if(orders.get(index).getOrderStatusArray() == OrderDetails.STATUS_DELIVERED){
				statusString = "DELIVERED";
			}else if(orders.get(index).getOrderStatusArray() == OrderDetails.STATUS_CANCEL){
				statusString = "CANCELLED";
			}else{
				statusString = "INVALID";
			}

        System.out.println("\n\n");
        System.out.println("           |--------------------------------------------------------------------------------------------------------------------------------------------------------|\n");
		System.out.printf("            %-18s           %-18s          %-18s           %-10s            %-18s            %-18s       \n", "Order ID", "Customer ID", "Name", "Quantity", "Order Value", "Order Status\n");
		System.out.println("           |--------------------------------------------------------------------------------------------------------------------------------------------------------|\n\n");
		System.out.printf("            %-18s           %-18s          %-18s           %-10s            %-18s            %-18s       \n", sOrder, num, name, burger, total, statusString);
		System.out.println("           |--------------------------------------------------------------------------------------------------------------------------------------------------------|\n\n\n");

        while(true){
            System.out.print("Do You Want To Exit (y/n) :- ");
            String yesOrNo = input.next();
            if(yesOrNo.equals("y")){
                clearScreen();
                startSystem();
                System.out.println("\n\n\n\n\n");
            }else if(yesOrNo.equals("n")){
                clearScreen();
                searchOrder();
            }else{
                clearScreen();
                System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
                System.out.println("\n\n\n");
            }
        }
    }else{
        while(true){
            System.out.print("\n\n\nInvalid Order ID.....Do You Want To Enter Again ? (y/n) :- ");
            String yesOrNo = input.next();
            if(yesOrNo.equals("y")){
                clearScreen();
                searchOrder();
                System.out.println("\n\n\n\n\n");
            }else if(yesOrNo.equals("n")){
                clearScreen();
                startSystem();
            }else{
                clearScreen();
                System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
                System.out.println("\n\n\n");
            }
        }
    }
}

public static void searchCustomer(){
	System.out.println("			||===============================================================================================================||\n\n");
	System.out.println("			   _________                           .__      _________                 __                               ");   
	System.out.println("			  /   _____/ ____ _____ _______   ____ |  |__   \\_   ___ \\ __ __  _______/  |_  ____   _____   ___________ "); 
	System.out.println("			  \\_____  \\_/ __ \\__  \\_  __   \\_/ ___\\|  |  \\  /    \\  \\/|  |  \\/  ___/\\   __\\/  _ \\ /     \\_/ __ \\_  __ \\");
	System.out.println("			  /        \\  ___/ / __ \\|  | \\/\\  \\___|   Y  \\ \\     \\___|  |  /\\___ \\  |  | (  <_> )  Y Y  \\  ___/|  | \\/");  
	System.out.println("			 /_______  /\\___  >____  /__|    \\___  >___|  /  \\______  /____//____  > |__|  \\____/|__|_|  /\\___  >__|   ");  
	System.out.println("			         \\/     \\/     \\/            \\/     \\/          \\/           \\/                    \\/     \\/       \n\n\n ");
	System.out.println("			||===============================================================================================================||\n\n\n\n\n\n");
	while(true){
        System.out.print("            Enter Customer ID :- ");
        String searchNumber = input.next();
        int index = -1;
        String tOrder;
        int tQuantity;
        double tValue;
        String tname = "";
        int tIndex = -1;

        for(OrderDetails order : orders){
			if(searchNumber.startsWith("0") && searchNumber.length() == 10 && searchNumber.equalsIgnoreCase(order.getNumbers())){
			index = 0;
			tIndex = orders.indexOf(order);
			tname = order.getNames();
			System.out.println("\n\n\n            Customer ID :- " + searchNumber + "\n\n");
			System.out.println("            Name        :- " + tname + "\n\n\n");
			System.out.println("            ||=====================||\n");
			System.out.println("            Customer Order Details\n");
			System.out.println("            ||=====================||\n\n\n");
			System.out.println("|------------------------------------------------------------------------------------|");
			System.out.println(" Order ID                  Order Quantity                    Total Value");
			System.out.println("|------------------------------------------------------------------------------------|\n");
			break; 
		}
	}

	for(OrderDetails order : orders){
		if(searchNumber.equalsIgnoreCase(order.getNumbers())){
			tOrder = order.getOrderIDs();
			tQuantity = order.getBurgers();
			tValue = order.getTotals();
			System.out.printf("  %-30s %-30s %-30s\n", tOrder, tQuantity, tValue);
		}
	}

        if(index != -1){
            System.out.println("|-----------------------------------------------------------------------------------|\n\n");
            System.out.print("        Do You Want To Search Another Customer Details (y/n) ?");
            String yesOrNo = input.next();
            if(yesOrNo.equals("y")){
                clearScreen();
                searchCustomer();
                System.out.println("\n\n\n\n\n");
            }else if(yesOrNo.equals("n")){
                clearScreen();
                startSystem();
            }else{
                clearScreen();
                System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
                System.out.println("\n\n\n");
            }
        }else if(index == -1){
            System.out.println("\n\n\n        This Customer ID Is Not Added Yet OR Invalid Number...........\n\n\n");

            while(true){
                System.out.print("        Do You Want To Search Another Customer Details (y/n) ?");
                String yesOrNo2 = input.next();
                if(yesOrNo2.equals("y")){
                    clearScreen();
                    searchCustomer();
                    System.out.println("\n\n\n\n\n");
                }else if(yesOrNo2.equals("n")){
                    clearScreen();
                    startSystem();
                }else{
                    clearScreen();
                    System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
                    System.out.println("\n\n\n");
                }
            }
        }
    }
}

public static void viewOrders(){
	System.out.println("			||==========================================================================================||\n\n");
	System.out.println("				   ____   ____.__                ________            .___                   ");   
	System.out.println("				  \\   \\ /   /|__| ______  _  __ \\_____  \\_______  __| _/___________  ______"); 
	System.out.println("				   \\   Y   / |  |/ __ \\ \\/ \\/ /  /   |   \\_  __ \\/ __ |/ __ \\_  __ \\/  ___/");
	System.out.println("				    \\     /  |  \\  ___/\\     /  /    |    \\  | \\/ /_/ \\  ___/|  | \\/\\___ \\ ");  
	System.out.println("				     \\___/   |__|\\___  >\\/\\_/   \\_______  /__|  \\____ |\\___  >__|  /____  >");  
	System.out.println("				                       \\/                 \\/           \\/    \\/           \\/ \n\n\n ");
	System.out.println("			||==========================================================================================||\n\n\n\n\n\n");
        System.out.println("            [1] Delivered Order\n\n");
        System.out.println("            [2] Preparing Order\n\n");
        System.out.println("            [3] Cancel Order\n\n");
        System.out.print("            Enter an option to Continue :- ");
    int num = input.nextInt();

    switch(num){
        case 1:
            displayOrdersByStatus(1, "Delivered Orders");
            break;
        case 2:
            displayOrdersByStatus(0, "Preparing Orders");
            break;
        case 3:
            displayOrdersByStatus(2, "Cancel Orders");
            break;
        default:
            handleInvalidInput();
    }

    while(true){
        handleExitOption();
    }
}

private static void displayOrdersByStatus(int status, String statusMessage){
    int index = -1;
    System.out.println("                    ||-----------------------------------------------------------------------------------------------------------------------------------------------------||");
    System.out.printf("                                %-18s           %-18s          %-18s           %-10s            %-18s            \n", "Order ID", "Customer ID", "Name", "Quantity", "Order Value\n");
    System.out.println("                    ||-----------------------------------------------------------------------------------------------------------------------------------------------------||");

    for(OrderDetails order : orders){
    if(order.getOrderStatusArray() == status){
        index = orders.indexOf(order);
        String numb = order.getNumbers();
        String orderId = order.getOrderIDs();
        String name = order.getNames();
        int burger = order.getBurgers();
        double total = order.getTotals();
            System.out.println("                    ||-----------------------------------------------------------------------------------------------------------------------------------------------------||\n\n");
            System.out.printf("                                %-18s           %-18s          %-18s           %-10s            %-18s            \n", order, numb, name, burger, total);
            System.out.println("                    ||-----------------------------------------------------------------------------------------------------------------------------------------------------||\n\n");
        }
    }

    if(index == -1){
        System.out.println("            \n\n\n                    \t\t\t\t\t\tNo " + statusMessage + " Found............\n\n\n");
        handleInvalidInput();
    }
}

private static void handleInvalidInput(){
    while(true){
        System.out.print("\n\n\n            \t\t\t\t\t\tInvalid Input.....Do You Want To Exit ? (y/n) :- ");
        String yesOrNo = input.next();

        if(yesOrNo.equals("y")){
            clearScreen();
            startSystem();
            System.out.println("\n\n\n\n\n");
        }else if(yesOrNo.equals("n")){
            clearScreen();
            viewOrders();
            System.out.println("\n\n\n\n\n");
        }else{
            clearScreen();
            System.out.println("            Invalid input. Please enter 'y' for Yes or 'n' for No.");
            System.out.println("\n\n\n");
        }
    }
}

private static void handleExitOption(){
    System.out.println("                    --------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("                                            ---------------------------------------------------------------------------------------------\n\n");
    System.out.print("            Do You Want To Exit ? (y/n) :- ");
    String yesOrNo = input.next();

    if(yesOrNo.equals("y")){
        clearScreen();
        startSystem();
        System.out.println("\n\n\n\n\n");
    }else if(yesOrNo.equals("n")){
        clearScreen();
        viewOrders();
    }else{
        clearScreen();
        System.out.println("            Invalid input. Please enter 'y' for Yes or 'n' for No.");
        System.out.println("\n\n\n");
    }
}

public static void updateOrder(){
	System.out.println("			||==========================================================================================||\n\n");
	System.out.println("			   ____ ___            .___       __           ________            .___            ");   
	System.out.println("			  |    |   \\______   __| _/____ _/  |_  ____   \\_____  \\_______  __| _/___________ "); 
	System.out.println("			  |    |   /\\____ \\ / __ |\\__  \\   __\\/ __ \\   /   |   \\_  __ \\/ __ |/ __ \\_  __ \\");
	System.out.println("			  |    |  / |  |_> > /_/ | / __ \\|  | \\  ___/  /    |    \\  | \\/ /_/ \\  ___/|  | \\/");  
	System.out.println("			  |______/  |   __/\\____ |(____  /__|  \\___  > \\_______  /__|  \\____ |\\_ __  >__|  ");  
	System.out.println("			              |__|        \\/     \\/          \\/          \\/           \\/    \\/       \n\n\n ");
	System.out.println("			||==========================================================================================||\n\n\n\n\n\n");
    System.out.print("|----------------------------|\n");
    System.out.print("  Enter Order ID :- ");
    String orderIDToUpdate = input.next();
    int index = findOrderIndex(orderIDToUpdate);

    if(index != -1){
        displayOrderDetails(index);

        if(OrderDetails.STATUS_DELIVERED == orders.get(index).getOrderStatusArray() || OrderDetails.STATUS_CANCEL == orders.get(index).getOrderStatusArray()){
            System.out.println("Sorry.....Order Can't Be Updated..........Already DELIVERED Or CANCELLED.");
        }else{
            System.out.println("\t\t\tWhat Do You Want To Update ? \n\n");
            System.out.println("\t\t\t[01] Quantity\n\n\n");
            System.out.println("\t\t\t[02] Status\n\n\n");
            System.out.print("\t\t\tEnter Your Option :- ");
            int option = input.nextInt();

            if(option == 1){
                updateQuantity(index);
            }else if(option == 2){
                updateStatus(index);
            }else{
                handleInvalidInput();
            }
        }
    }else if(index == -1){
        while (true){
            System.out.print("\n\n\n\t\t\tInvalid Order ID.....Do You Want To Enter Again ? (y/n) :- ");
            String yesOrNo = input.next();

            if(yesOrNo.equals("y")){
                clearScreen();
                updateOrder();
                System.out.println("\n\n\n\n\n");
            }else if(yesOrNo.equals("n")){
                clearScreen();
                startSystem();
            }else{
                clearScreen();
                System.out.println("\n\n\n\t\t\tInvalid input. Please enter 'y' for Yes or 'n' for No.");
                System.out.println("\n\n\n");
            }
        }
    }
}

public static int findOrderIndex(String orderID){
    int index = 0;
    for(OrderDetails order : orders){
        if(orderID.equalsIgnoreCase(order.getOrderIDs())){
            return index;
        }
        index++;
    }
    return -1;
}

private static void displayOrderDetails(int index){
    if(index >= 0 && index < orders.size()){
        String statusString = getStatusString(orders.get(index).getOrderStatusArray());

        System.out.println("Order ID: " + orders.get(index).getOrderIDs());
        System.out.println("|----------------------------|\n\n");
        System.out.println("Customer ID: " + orders.get(index).getNumbers() + "\n\n");
        System.out.println("Name: " + orders.get(index).getNames() + "\n\n");
        System.out.println("Quantity: " + orders.get(index).getBurgers() + "\n\n");
        System.out.println("Order Value: " + orders.get(index).getTotals() + "\n\n");
        System.out.println("Order Status: " + statusString + "\n\n");
    }else{
        System.out.println("Invalid index.");
    }
}

private static String getStatusString(int index){
    if(orders.get(index).getOrderStatusArray() == OrderDetails.STATUS_PREPARING){
        return "PREPARING";
    }else if(orders.get(index).getOrderStatusArray() == OrderDetails.STATUS_DELIVERED){
        return "DELIVERED";
    }else if(orders.get(index).getOrderStatusArray() == OrderDetails.STATUS_CANCEL){
        return "CANCELLED";
    }else{
        return "INVALID";
    }
}

private static void updateQuantity(int index){
    System.out.println("Quantity Update");
    System.out.println("================\n\n\n");

    System.out.println("Order ID :- " + orders.get(index).getOrderIDs() + "\n\n");
    System.out.println("Customer ID :- " + orders.get(index).getNumbers() + "\n\n");
    System.out.println("Name :- " + orders.get(index).getNames() + "\n\n");

    System.out.print("Enter Your Quantity Update Value :- ");
    int newQuantity = input.nextInt();
    orders.get(index).setBurgers(newQuantity);
    orders.get(index).setTotals(newQuantity * 500);

    System.out.println("\n\nUpdate Order Quantity Successfully......\n\n\n");
    System.out.println("New Order Quantity :- " + newQuantity + "\n\n");
    System.out.println("New Order Value :- " + orders.get(index).getTotals() + "\n\n");
    handleUpdateAnotherOrder();
}

private static void updateStatus(int index){
    System.out.println("Status Update");
    System.out.println("================\n\n\n");

    System.out.println("Order ID :- " + orders.get(index).getOrderIDs() + "\n\n");
    System.out.println("Customer ID :- " + orders.get(index).getNumbers() + "\n\n");
    System.out.println("Name :- " + orders.get(index).getNames() + "\n\n\n\n");
    System.out.println("\t\t\t[0] Cancel\n");
    System.out.println("\t\t\t[1] Preparing\n");
    System.out.println("\t\t\t[2] Delivered\n\n");

    System.out.print("Enter New Order Status :- ");
    char newStatus = input.next().charAt(0);

    if(newStatus == '0'){
        orders.get(index).setOrderStatusArray(OrderDetails.STATUS_CANCEL);
    }else if(newStatus == '1'){
        orders.get(index).setOrderStatusArray(OrderDetails.STATUS_PREPARING);
    }else if(newStatus == '2'){
        orders.get(index).setOrderStatusArray(OrderDetails.STATUS_DELIVERED);
    }

    System.out.println("\n\nNew Order Status :- " + getStatusString(index) + "\n\n\n");
    handleUpdateAnotherOrder();
}

private static void handleUpdateAnotherOrder(){
    while(true){
        System.out.print("Do You Want To Update Another Order Details ? (y/n) ");
        String yesOrNo = input.next();

        if(yesOrNo.equals("y")){
            clearScreen();
            updateOrder();
            System.out.println("\n\n\n\n\n");
        }else if(yesOrNo.equals("n")){
            clearScreen();
            startSystem();
        }else{
            clearScreen();
            handleInvalidInput();
        }
    }
}

       
    public static String getLastOrderID(){
        if (!orders.isEmpty()){
            String lastId = orders.get(orders.size() - 1).getOrderIDs();
            String[] ar = lastId.split("[B]");
            int num = Integer.parseInt(ar[1]);
            num++;
            return String.format("B%04d", num);
        }
        return "B0001";
    }

    

    public static String getName(){
        System.out.print("    Enter Customer Name :- ");
        return input.next();
    }

    public static int getBurger() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Burger Quantity: ");
        return input.nextInt();
    }

   private static final double BURGER_PRICE = 500; 

    public static double getTotal(int burgerQuantity) {
        return BURGER_PRICE * burgerQuantity;
    }
    
    public static OrderDetails getOrderById(String orderId) {
    for (OrderDetails order : orders) {
        if (order.getOrderIDs().equals(orderId)) {
            return order;
        }
    }
    return null;
}
    public static OrderDetails getCustomerById(String orderId) {
    for (OrderDetails order : orders) {
        if (order.getNumbers().equals(orderId)) {
            return order;
        }
    }
    return null;
}
}

