import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Map<String, Item> inventory = new HashMap<>();

    public static void addItem(){
        System.out.println();
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        boolean checkname = true;
        while (checkname){
            if (inventory.containsKey(itemName)) {
                System.out.println("Item already exists in inventory. Enter a new item name: ");
                return;
            } else {
                checkname = false;
            }
            System.out.print("Enter item price: ");
            int itemPrice = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter item quantity: ");
            int itemQuantity = Integer.parseInt(scanner.nextLine());
            System.out.println();
            inventory.put (itemName, new Item(itemName, itemPrice, itemQuantity));
            System.out.println("Item "+ itemName + " successfully added to inventory.");
            
        }


    }

    public static void displayInventory(){
        System.out.println("Inventory: ");
        System.out.printf("%-15s %10s %10s\n" , "Item Name: " , "Item Price: " , "Item Quantity: ");
            System.out.println("----------------------------------------------------");
        for (Map.Entry<String, Item> entry : inventory.entrySet()) {
            Item item = entry.getValue();
            System.out.printf("%-15s %10.2f %10d\n" , item.name , item.price , item.quantity);
        }
    }
    
    public static void main(String[] args) {
        
while (true){
        System.out.println("Welcome to your Inventory Management System");
        System.out.println("1. Add item to inventory");
        System.out.println("2. Remove item from inventory");
        System.out.println("3. Update item quantity");
        System.out.println("4. View inventory");
        System.out.println("5. Exit"); 
        System.out.print("Choose an option: ");
        int option = Integer.parseInt(scanner.nextLine());

        
            switch (option) {
                case 1:
                System.out.println();
                    System.out.print("Enter the number of items you want to add to your inventory: ");
                    int numItems = Integer.parseInt(scanner.nextLine());
        
                    for (int i = 0; i < numItems; i++) {
                        addItem();
                        System.out.println();
                    }
                
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4: 
                        displayInventory();
                        System.out.println();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    System.out.println();
        }
    }





        
    }
}