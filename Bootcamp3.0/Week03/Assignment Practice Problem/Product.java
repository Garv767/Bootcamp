import java.util.UUID;
import java.util.Arrays;

public class Product {
    // Instance variables
    public String productId;
    private String productName;
    private double price;
    private String category;
    private int stockQuantity;

    // Static variables
    private static int totalProducts = 0;
    private static String[] categories = new String[10]; // Fixed-size array for categories
    private static int categoryCount = 0;

    // Constructor
    public Product(String productName, double price, String category, int stockQuantity) {
        this.productId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        totalProducts++;
        addCategory(category);
    }

    // Static helper method to add categories
    private static void addCategory(String newCategory) {
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].equalsIgnoreCase(newCategory)) {
                return; // Category already exists
            }
        }
        if (categoryCount < categories.length) {
            categories[categoryCount++] = newCategory;
        }
    }

    // Static method: Find product by ID
    public static Product findProductById(Product[] products, String productId) {
        for (Product p : products) {
            if (p != null && p.getProductId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

    // Static method: Get products by category
    public static Product[] getProductsByCategory(Product[] products, String category) {
        Product[] result = new Product[totalProducts];
        int count = 0;
        for (Product p : products) {
            if (p != null && p.getCategory().equalsIgnoreCase(category)) {
                result[count++] = p;
            }
        }
        return Arrays.copyOf(result, count);
    }

    // Getters and Setters
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public void displayProductInfo() {
        System.out.printf("  %-10s | %-25s | $%-8.2f | %-15s | %s%n",
            productId, productName, price, category, stockQuantity > 0 ? "In Stock" : "Out of Stock");
    }

    public static void displayAllCategories() {
        System.out.println("Available Categories:");
        for (int i = 0; i < categoryCount; i++) {
            System.out.println("- " + categories[i]);
        }
    }
}
