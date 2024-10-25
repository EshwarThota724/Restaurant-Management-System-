import java.util.ArrayList;

class Cart {
    private final ArrayList<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.name + " added to cart.");
    }

    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("Items in Cart:");
        for (Item item : items) {
            System.out.println(item.name + " - $" + item.price);
        }
    }

    public void removeItem(int itemId) {
        boolean removed = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).id == itemId) {
                items.remove(i);
                System.out.println("Item removed from cart.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Item not found in cart.");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.price;
        }
        total -= calculateComboDiscount(); // Apply combo discount
        return total;
    }

    public void printComboOffer() {
        int biryaniCount = 0;
        int breakfastCount = 0;
        int snackCount = 0;
        int drinkCount = 0;

        for (Item item : items) {
            if (item.category.equals("Lunch") && item.name.contains("Biryani")) {
                biryaniCount++;
            } else if (item.category.equals("Breakfast")) {
                breakfastCount++;
            } else if (item.category.equals("Snacks")) {
                snackCount++;
            } else if (item.category.equals("Beverages")) {
                drinkCount++;
            }
        }

        // Display combo offers
        if (biryaniCount == 2) {
            System.out.println("Combo Offer: Buy 2 Biryanis and get a Drink for free!");
        }
        if (breakfastCount == 2) {
            System.out.println("Combo Offer: Buy 2 Breakfast items and get 1 Coffee for free!");
        }
        if (snackCount == 2) {
            System.out.println("Combo Offer: Buy 2 Snack items and get 1 Tea for free!");
        }
        if (breakfastCount == 1 && drinkCount == 1) {
            System.out.println("Combo Offer: Buy 1 Breakfast and get a Drink for free!");
        }
    }

    private double calculateComboDiscount() {
        double discount = 0;
        int biryaniCount = 0;
        int drinkCount = 0;

        for (Item item : items) {
            if (item.category.equals("Lunch") && item.name.contains("Biryani")) {
                biryaniCount++;
            } else if (item.category.equals("Beverages")) {
                drinkCount++;
            }
        }

        if (biryaniCount == 2 && drinkCount > 0) {
            discount += 1; // Assuming the price of one drink is $1
        }

        if (biryaniCount == 2) {
            discount += 2; // Assuming the price of Coffee for two breakfasts
        }

        return discount;
    }
}
