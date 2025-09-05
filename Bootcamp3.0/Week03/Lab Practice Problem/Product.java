import java.util.UUID;
import java.util.Arrays;

public class Product {
    // a. Private instance variables
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private String supplierName;
    private String category;

    // b. Static variables for inventory tracking
    private static int totalProducts = 0;
    private static double totalInventoryValue = 0.0;
    private static int lowStockCount = 0;
    private static String[] categories = new String[10]; // Static array for categories
    private static int categoryCount = 0;

    // a. Constructor
    public Product(String productName, double price, int quantity, String supplierName, String category) {
        this.productId = "PROD-" + UUID.randomUUID().toString().substring(0, 5);
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.supplierName = supplierName;
        this.category = category;

        // Update static variables
        totalProducts++;
        updateTotalInventoryValue(this.calculateProductValue());
        if (isLowStock()) {
            lowStockCount++;
        }
        addCategory(category);
    }

    // e. Static method to calculate total inventory value
    public static double calculateTotalInventoryValue(Product[] products) {
        double totalValue = 0;
        for (Product p : products) {
            if (p != null) {
                totalValue += p.calculateProductValue();
            }
        }
        return totalValue;
    }

    // e. Static method to find low stock products
    public static Product[] findLowStockProducts(Product[] products) {
        Product[] lowStock = new Product[totalProducts];
        int count = 0;
        for (Product p : products) {
            if (p != null && p.isLowStock()) {
                lowStock[count++] = p;
            }
        }
        return Arrays.copyOf(lowStock, count);
    }

    // e. Static method to generate inventory report
    public static void generateInventoryReport(Product[] products) {
        System.out.println("--- INVENTORY REPORT ---");
        System.out.println("Total Products: " + totalProducts);
        System.out.printf("Total Inventory Value: $%.2f%n", calculateTotalInventoryValue(products));
        System.out.println("Products with Low Stock: " + lowStockCount);
        System.out.println("Unique Categories: " + Arrays.toString(Arrays.copyOf(categories, categoryCount)));
        System.out.println("------------------------");
    }

    // b. Static helper method to update total inventory value
    private static void updateTotalInventoryValue(double valueChange) {
        totalInventoryValue += valueChange;
    }

    // b. Static helper method to track categories
    private static void addCategory(String newCategory) {
        boolean found = false;
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].equals(newCategory)) {
                found = true;
                break;
            }
        }
        if (!found && categoryCount < categories.length) {
            categories[categoryCount++] = newCategory;
        }
    }

    // c. Instance method: addStock(int quantity)
    public void addStock(int quantity) {
        if (quantity > 0) {
            updateTotalInventoryValue(-(calculateProductValue())); // Subtract old value
            this.quantity += quantity;
            updateTotalInventoryValue(calculateProductValue()); // Add new value
            if (this.quantity >= 10 && this.quantity - quantity < 10) {
                lowStockCount--;
            }
            System.out.println(quantity + " units added to " + productName + ".");
        }
    }

    // c. Instance method: reduceStock(int quantity)
    public boolean reduceStock(int quantity) {
        if (quantity > 0 && this.quantity >= quantity) {
            updateTotalInventoryValue(-(calculateProductValue())); // Subtract old value
            this.quantity -= quantity;
            updateTotalInventoryValue(calculateProductValue()); // Add new value
            if (this.quantity < 10 && this.quantity + quantity >= 10) {
                lowStockCount++;
            }
            System.out.println(quantity + " units sold for " + productName + ".");
            return true;
        }
        System.out.println("Not enough stock for " + productName + ".");
        return false;
    }

    // c. Instance method: isLowStock()
    public boolean isLowStock() {
        return quantity < 10;
    }

    // d. Instance method: calculateProductValue()
    public double calculateProductValue() {
        return price * quantity;
    }

    // d. Instance method: updatePrice(double newPrice)
    public void updatePrice(double newPrice) {
        updateTotalInventoryValue(-(calculateProductValue())); // Subtract old value
        this.price = newPrice;
        updateTotalInventoryValue(calculateProductValue()); // Add new value
        System.out.println("Price for " + productName + " updated to $" + newPrice + ".");
    }

    // d. Instance method: displayProductInfo()
    public void displayProductInfo() {
        System.out.println("--- Product: " + productName + " ---");
        System.out.println("ID: " + productId);
        System.out.println("Category: " + category);
        System.out.println("Supplier: " + supplierName);
        System.out.printf("Price: $%.2f%n", price);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Total Value: $%.2f%n", calculateProductValue());
        System.out.println("Status: " + (isLowStock() ? "LOW STOCK" : "In Stock"));
        System.out.println("-----------------------------------");
    }

    // f. Static method: searchProduct(Product[] products, String productName)
    public static Product searchProduct(Product[] products, String productName) {
        for (Product p : products) {
            if (p != null && p.productName.equalsIgnoreCase(productName)) {
                return p;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // g. Create an array of Product objects
        Product[] inventory = new Product[5];
        inventory[0] = new Product("Laptop", 1200.0, 5, "Tech Supplies Inc.", "Electronics");
        inventory[1] = new Product("Smartphone", 800.0, 15, "Mobile World", "Electronics");
        inventory[2] = new Product("Office Chair", 150.0, 8, "Furniture Co.", "Furniture");
        inventory[3] = new Product("Notebook", 5.0, 200, "Paper Plus", "Stationery");

        System.out.println("--- Initial Inventory ---");
        for (Product p : inventory) {
            if (p != null) p.displayProductInfo();
        }

        // g. Demonstrate inventory operations and static/instance members
        System.out.println("\n--- Demonstrating Operations ---");
        Product laptop = searchProduct(inventory, "Laptop");
        if (laptop != null) {
            laptop.reduceStock(2); // Change instance variable
            laptop.displayProductInfo();
        }

        Product chair = searchProduct(inventory, "Office Chair");
        if (chair != null) {
            chair.addStock(5); // Change instance variable
            chair.displayProductInfo();
        }
        
        System.out.println("\n--- Low Stock Check ---");
        Product[] lowStockProducts = findLowStockProducts(inventory);
        System.out.println("Products currently with low stock:");
        for (Product p : lowStockProducts) {
            p.displayProductInfo();
        }
        
        System.out.println("\n--- Generating Reports ---");
        generateInventoryReport(inventory);
    }
}
