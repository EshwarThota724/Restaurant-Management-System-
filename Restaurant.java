import java.util.HashMap;
import java.util.Scanner;

public class Restaurant {
    static HashMap<Integer, Item> items;
    Cart cart;
    Scanner sc;

    public Restaurant() {
        items = new HashMap<>();
        cart = new Cart();
        sc = new Scanner(System.in);
        initializeItems(); // Populate initial items
    }

    void initializeItems() {
        // Breakfast items
        items.put(1, new Item(1, "Pancakes", "Breakfast", 10));
        items.put(2, new Item(2, "Omelette", "Breakfast", 15));
        items.put(3, new Item(3, "Idly", "Breakfast", 25));
        items.put(4, new Item(4, "Dosa", "Breakfast", 30));
        items.put(5, new Item(5, "Upma Dosa", "Breakfast", 35));
        items.put(6, new Item(6, "Egg Dosa", "Breakfast", 40));
        items.put(7, new Item(7, "Puri", "Breakfast", 30));

        // Lunch items
        items.put(8, new Item(8, "Chicken Biryani", "Lunch", 150));
        items.put(9, new Item(9, "Veg Biryani", "Lunch", 130));
        items.put(10, new Item(10, "Mutton Biryani", "Lunch", 230));
        items.put(11, new Item(11, "Dilkush Biryani", "Lunch", 330));
        items.put(12, new Item(12, "Veg Meals", "Lunch", 65));
        items.put(13, new Item(13, "Non-veg Meals", "Lunch", 85));
        items.put(14, new Item(14, "Corn Fried Rice", "Lunch", 100));

        // Snacks items
        items.put(15, new Item(15, "Chicken Manchuria", "Snacks", 110));
        items.put(16, new Item(16, "Veg Manchuria", "Snacks", 80));
        items.put(17, new Item(17, "Samosa", "Snacks", 20));
        items.put(18, new Item(18, "Noodles", "Snacks", 70));

        // Beverages items
        items.put(19, new Item(19, "Mango Juice", "Beverages", 5));
        items.put(20, new Item(20, "Apple Juice", "Beverages", 5));
        items.put(21, new Item(21, "Pineapple Juice", "Beverages", 5));
        items.put(22, new Item(22, "Banana Juice", "Beverages", 5));
        items.put(23, new Item(23, "Mojito", "Beverages", 10));
        items.put(24, new Item(24, "Lady Margarita", "Beverages", 12));
        items.put(25, new Item(25, "Thumbs Up", "Beverages", 2));
        items.put(26, new Item(26, "Sprite", "Beverages", 2));
        items.put(27, new Item(27, "Limca", "Beverages", 2));
        items.put(28, new Item(28, "Monster", "Beverages", 3));
        items.put(29, new Item(29, "Red Bull", "Beverages", 4));
        items.put(30, new Item(30, "Tea", "Beverages", 1));
        items.put(31, new Item(31, "Coffee", "Beverages", 2));
    }

    static void menu() {
        System.out.println("****** Welcome To Restaurant Management System ***** "
                + "\n0. Menu" + "\n1. Add Item to Cart" + "\n2. Show Cart"
                + "\n3. Remove Item from Cart" + "\n4. View All Items"
                + "\n5. Print Total Bill" + "\n6. Exit ");
    }

    void displayItems() {
        System.out.println("Select a meal time:");
        System.out.println("1. Breakfast");
        System.out.println("2. Lunch");
        System.out.println("3. Snacks");
        System.out.println("4. Beverages");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                displayBreakfastItems();
                break;
            case 2:
                displayLunchItems();
                break;
            case 3:
                displaySnackItems();
                break;
            case 4:
                displayBeverageItems();
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    void displayBreakfastItems() {
        System.out.println("Breakfast Menu:");
        for (Item item : items.values()) {
            if (item.category.equals("Breakfast")) {
                System.out.println(item.id + ". " + item.name + " - $" + item.price);
            }
        }
    }

    void displayLunchItems() {
        System.out.println("Lunch Menu:");
        for (Item item : items.values()) {
            if (item.category.equals("Lunch")) {
                System.out.println(item.id + ". " + item.name + " - $" + item.price);
            }
        }
    }

    void displaySnackItems() {
        System.out.println("Snacks Menu:");
        for (Item item : items.values()) {
            if (item.category.equals("Snacks")) {
                System.out.println(item.id + ". " + item.name + " - $" + item.price);
            }
        }
    }

    void displayBeverageItems() {
        System.out.println("Beverages Menu:");
        for (Item item : items.values()) {
            if (item.category.equals("Beverages")) {
                System.out.println(item.id + ". " + item.name + " - $" + item.price);
            }
        }
    }

    void start() {
        while (true) {
            menu();
            int choice = sc.nextInt();

            switch (choice) {
                case 0:
                    displayItems();
                    break;
                case 1:
                    System.out.println("Enter item ID to add to cart:");
                    int idToAdd = sc.nextInt();
                    if (items.containsKey(idToAdd)) {
                        cart.addItem(items.get(idToAdd));
                        cart.printComboOffer(); // Check combo offers after adding
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 2:
                    cart.showItems();
                    break;
                case 3:
                    System.out.println("Enter item ID to remove from cart:");
                    int idToRemove = sc.nextInt();
                    cart.removeItem(idToRemove);
                    break;
                case 4:
                    cart.showItems();
                    break;
                case 5:
                    double total = cart.calculateTotal();
                    System.out.println("Total Amount: $" + total);
                    break;
                case 6:
                    System.out.println("Thank you for visiting! Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        restaurant.start();
    }
}
