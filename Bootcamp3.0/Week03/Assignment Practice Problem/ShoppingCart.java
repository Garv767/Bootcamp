import java.util.UUID;
import java.util.Arrays;

public class ShoppingCart {
    // Instance variables
    private String cartId;
    private String customerName;
    private Product[] products; // Product array to hold cart items
    private int[] quantities;   // Parallel array for item quantities
    private double cartTotal;
    private int itemCount;

    // Constructor
    public ShoppingCart(String customerName) {
        this.cartId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.customerName = customerName;
        this.products = new Product[10]; // Capacity of 10 items
        this.quantities = new int[10];
        this.cartTotal = 0.0;
        this.itemCount = 0;
    }

    // Method to add a product to the cart
    public void addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            System.out.println("Invalid product or quantity.");
            return;
        }
        if (product.getStockQuantity() < quantity) {
            System.out.println("Insufficient stock for " + product.getProductName());
            return;
        }
        if (itemCount >= products.length) {
            System.out.println("Cart is full.");
            return;
        }

        for (int i = 0; i < itemCount; i++) {
            if (products[i].getProductId().equals(product.getProductId())) {
                quantities[i] += quantity;
                product.setStockQuantity(product.getStockQuantity() - quantity);
                System.out.println("Added " + quantity + " units of " + product.getProductName() + " to cart.");
                calculateTotal();
                return;
            }
        }
        
        products[itemCount] = product;
        quantities[itemCount] = quantity;
        itemCount++;
        product.setStockQuantity(product.getStockQuantity() - quantity);
        System.out.println("Added " + product.getProductName() + " to cart.");
        calculateTotal();
    }

    // Method to remove a product from the cart
    public void removeProduct(String productId) {
        for (int i = 0; i < itemCount; i++) {
            if (products[i].getProductId().equals(productId)) {
                // Restore stock
                products[i].setStockQuantity(products[i].getStockQuantity() + quantities[i]);
                System.out.println("Removed " + products[i].getProductName() + " from cart.");

                // Shift array elements to fill the gap
                for (int j = i; j < itemCount - 1; j++) {
                    products[j] = products[j + 1];
                    quantities[j] = quantities[j + 1];
                }
                products[itemCount - 1] = null;
                quantities[itemCount - 1] = 0;
                itemCount--;
                calculateTotal();
                return;
            }
        }
        System.out.println("Product with ID " + productId + " not found in cart.");
    }

    // Method to calculate the total cart value
    public void calculateTotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += products[i].getPrice() * quantities[i];
        }
        this.cartTotal = total;
    }

    // Method to display cart contents
    public void displayCart() {
        System.out.println("----------------------------------------");
        System.out.println("Cart ID: " + cartId);
        System.out.println("Customer: " + customerName);
        System.out.println("Items in Cart:");
        if (itemCount == 0) {
            System.out.println("  Cart is empty.");
        } else {
            System.out.printf("  %-25s | %-10s | %-10s%n", "Product", "Quantity", "Subtotal");
            for (int i = 0; i < itemCount; i++) {
                System.out.printf("  %-25s | %-10d | $%-10.2f%n",
                    products[i].getProductName(), quantities[i], products[i].getPrice() * quantities[i]);
            }
        }
        System.out.printf("Cart Total: $%.2f%n", cartTotal);
        System.out.println("----------------------------------------");
    }

    // Method to simulate checkout
    public void checkout() {
        if (itemCount == 0) {
            System.out.println("Cannot checkout with an empty cart.");
            return;
        }
        System.out.println("Processing checkout for " + customerName + "...");
        System.out.printf("Total amount: $%.2f%n", cartTotal);
        System.out.println("Thank you for your purchase!");
        
        // Reset cart
        this.products = new Product[10];
        this.quantities = new int[10];
        this.itemCount = 0;
        this.cartTotal = 0.0;
    }
}
