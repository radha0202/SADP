import java.util.*;

class MenuItem {
    private String name;
    private String type; 
    private double price;

    public MenuItem(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " (" + type + ") - ₹" + price;
    }
}

interface MenuIterator {
    boolean hasNext();
    MenuItem next();
}

class MenuItemIterator implements MenuIterator {
    private List<MenuItem> items;
    private int position = 0;

    public MenuItemIterator(List<MenuItem> items) {
        this.items = items;
    }

    public boolean hasNext() {
        return position < items.size();
    }

    public MenuItem next() {
        return items.get(position++);
    }
}

interface Menu {
    MenuIterator createIterator();
}

class FoodMenu implements Menu {
    private List<MenuItem> items = new ArrayList<>();

    public void addItem(String name, String type, double price) {
        items.add(new MenuItem(name, type, price));
    }

    public MenuIterator createIterator() {
        return new MenuItemIterator(items);
    }

    public List<MenuItem> getItems() {
        return items;
    }
}

public class MenuIteratorPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FoodMenu breakfast = new FoodMenu();
        breakfast.addItem("Idli Sambar", "Veg", 40);
        breakfast.addItem("Masala Dosa", "Veg", 50);
        breakfast.addItem("Egg Omelette", "Non-Veg", 60);
        breakfast.addItem("Paratha", "Veg", 30);
        breakfast.addItem("Bacon Sandwich", "Non-Veg", 80);

        FoodMenu lunch = new FoodMenu();
        lunch.addItem("Paneer Butter Masala", "Veg", 150);
        lunch.addItem("Veg Pulao", "Veg", 120);
        lunch.addItem("Chicken Curry", "Non-Veg", 200);
        lunch.addItem("Dal Fry", "Veg", 100);
        lunch.addItem("Mutton Biryani", "Non-Veg", 250);

        FoodMenu dinner = new FoodMenu();
        dinner.addItem("Veg Biryani", "Veg", 130);
        dinner.addItem("Dal Makhani", "Veg", 110);
        dinner.addItem("Palak Paneer", "Veg", 140);
        dinner.addItem("Butter Chicken", "Non-Veg", 220);
        dinner.addItem("Fish Curry", "Non-Veg", 200);

        FoodMenu dessert = new FoodMenu();
        dessert.addItem("Gulab Jamun", "Veg", 50);
        dessert.addItem("Rasgulla", "Veg", 50);
        dessert.addItem("Ice Cream", "Veg", 60);
        dessert.addItem("Brownie", "Veg", 80);
        dessert.addItem("Cheesecake", "Veg", 100);

        double totalBill = 0;
        List<String> orderedItems = new ArrayList<>();

        while (true) {
            System.out.println("\nSelect Menu Category:");
            System.out.println("1. Breakfast");
            System.out.println("2. Lunch");
            System.out.println("3. Dinner");
            System.out.println("4. Dessert");
            System.out.println("5. Exit & Show Bill");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            FoodMenu selectedMenu = null;
            switch (choice) {
                case 1: selectedMenu = breakfast; break;
                case 2: selectedMenu = lunch; break;
                case 3: selectedMenu = dinner; break;
                case 4: selectedMenu = dessert; break;
                case 5:
                    System.out.println("\n--- Your Bill ---");
                    for (String item : orderedItems) {
                        System.out.println(item);
                    }
                    System.out.println("Total Amount: ₹" + totalBill);
                    System.out.println("Thank you for ordering!");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            
            MenuIterator iterator = selectedMenu.createIterator();
            int index = 1;
            Map<Integer, MenuItem> menuMap = new HashMap<>();
            System.out.println("\n--- Menu ---");
            while (iterator.hasNext()) {
                MenuItem item = iterator.next();
                System.out.println(index + ". " + item);
                menuMap.put(index, item);
                index++;
            }

            
            System.out.print("Enter the number of the dish you want to order: ");
            int dishNo = sc.nextInt();
            sc.nextLine();
            if (menuMap.containsKey(dishNo)) {
                MenuItem ordered = menuMap.get(dishNo);
                orderedItems.add(ordered.toString());
                totalBill += ordered.getPrice();
                System.out.println(ordered.getName() + " added to your order.");
            } else {
                System.out.println("Invalid dish number.");
            }

            System.out.print("Would you like to order another? (yes/no): ");
            String another = sc.nextLine().trim().toLowerCase();
            if (!another.equals("yes")) {
                System.out.println("\n--- Your Bill ---");
                for (String item : orderedItems) {
                    System.out.println(item);
                }
                System.out.println("Total Amount: ₹" + totalBill);
                System.out.println("Thank you for ordering!");
                return;
            }
        }
    }
}

