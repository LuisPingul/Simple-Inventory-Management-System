import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;
import java.util.HashMap;
import java.util.Map;


/**
 * The Main class serves as the entry point for the Simple Inventory Management System.
 * It provides methods to add, remove, update, and display items in the inventory.
 * The inventory is stored as a Map with item names as keys and Item objects as values.
 * 
 * Methods:
 * - addItem(): Prompts the user to enter item details and adds the item to the inventory.
 * - updateItemQuantity(): Prompts the user to enter an item name and new quantity, then updates the item's quantity in the inventory.
 * - removeItem(): Prompts the user to enter an item name and removes the item from the inventory.
 * - displayInventory(): Displays the current inventory with item names, prices, and quantities.
 * - main(String[] args): Displays a menu with options to add, remove, update, and view items in the inventory, as well as an option to exit the program.
 * 
 * The program runs in a loop until the user chooses to exit.
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Map<String, Item> inventory = new HashMap<>();

    /**
     * Adds a new item to the inventory. Prompts the user to enter the item name, price, and quantity.
     * If the item already exists in the inventory, it will prompt the user to enter a new item name.
     * The item is then added to the inventory with the specified details.
     *
     * Note: This method assumes that a scanner object and an inventory map are already defined and accessible.
     */
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



    /**
     * Updates the quantity of an item in the inventory.
     * Prompts the user to enter the item name and the new quantity.
     * If the item exists in the inventory, its quantity is updated.
     * Otherwise, it notifies the user that the item does not exist.
     */
    public static void updateItemQuantity(){
        System.out.println();
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        if (inventory.containsKey(itemName)) {
            System.out.print("Enter new quantity: ");
            int newQuantity = Integer.parseInt(scanner.nextLine());
            inventory.get(itemName).quantity = newQuantity;
            System.out.println("Item quantity updated successfully.");
        } else {
            System.out.println("Item does not exist in inventory.");
        }
    }


    /**
     * Removes an item from the inventory.
     * Prompts the user to enter the name of the item to be removed.
     * If the item exists in the inventory, it is removed and a success message is displayed.
     * If the item does not exist, an error message is displayed.
     */
    public static void removeItem(){
        System.out.println();
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        if (inventory.containsKey(itemName)) {
            inventory.remove(itemName);
            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Item does not exist in inventory.");
        }
    }

    
    /**
     * Displays the current inventory of items.
     * The inventory includes the item name, item price, and item quantity.
     * The items are printed in a tabular format with columns for each attribute.
     */
    public static void displayInventory(){
        System.out.println("Inventory: ");
        System.out.printf("%-15s %10s %10s\n" , "Item Name: " , "Item Price: " , "Item Quantity: ");
            System.out.println("----------------------------------------------------");
        for (Map.Entry<String, Item> entry : inventory.entrySet()) {
            Item item = entry.getValue();
            System.out.printf("%-15s %10.2f %10d\n" , item.name , item.price , item.quantity);
        }
    }
    
    /**
     * The main method serves as the entry point for the Inventory Management System.
     * It displays a menu with options to add, remove, update, and view items in the inventory,
     * as well as an option to exit the program. The user is prompted to choose an option,
     * and the corresponding action is performed based on the user's input.
     *
     * Menu options:
     * 1. Add item to inventory
     * 2. Remove item from inventory
     * 3. Update item quantity
     * 4. View inventory
     * 5. Exit
     *
     * The program runs in a loop until the user chooses to exit.
     *
     * @param args Command line arguments (not used in this program)
     */
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
                    removeItem();
                    System.out.println();
                    break;

                case 3:
                    updateItemQuantity();
                    System.out.println();
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