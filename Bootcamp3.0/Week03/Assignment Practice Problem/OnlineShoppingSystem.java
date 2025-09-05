import java.util.Scanner;

public class OnlineShoppingSystem {
    private static Product[] products;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize products
        initializeProducts();
        
        System.out.print("Enter your name to start shopping: ");
        String customerName = scanner.nextLine();
        ShoppingCart cart = new ShoppingCart(customerName);

        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    browseProducts();
                    break;
                case 2:
                    Product.displayAllCategories();
                    System.out.print("Enter category to filter: ");
                    String category = scanner.nextLine();
                    browseProductsByCategory(category);
                    break;
                case 3:
                    addProductToCart(cart);
                    break;
                case 4:
                    removeProductFromCart(cart);
                    break;
                case 5:
                    cart.displayCart();
                    break;
                case 6:
                    cart.checkout();
                    break;
                case 0:
                    System.out.println("Thank you for shopping with us!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        
        scanner.close();
    }

    private static void initializeProducts() {
        products = new Product[10];
        products[0] = new Product("Laptop Pro", 1500.00, "Electronics", 10);
        products[1] = new Product("Smartphone X", 999.00, "Electronics", 25);
        products[2] = new Product("Wireless Mouse", 25.50, "Accessories", 50);
        products[3] = new Product("Mechanical Keyboard", 120.00, "Accessories", 20);
        products[4] = new Product("Designer T-Shirt", 35.00, "Apparel", 40);
        products[5] = new Product("Jeans Regular Fit", 55.00, "Apparel", 30);
        products[6] = new Product("Book - The Martian", 15.00, "Books", 100);
        products[7] = new Product("Book - Dune", 18.50, "Books", 75);
        products[8] = new Product("Coffee Maker", 75.00, "Home Appliances", 15);
        products[9] = new Product("Blender", 45.00, "Home Appliances", 12);
    }

    private static void displayMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Browse All Products");
        System.out.println("2. Browse Products by Category");
        System.out.println("3. Add Product to Cart");
        System.out.println("4. Remove Product from Cart");
        System.out.println("5. View Cart");
        System.out.println("6. Checkout");
        System.out.println("0. Exit");
    }

    private static void browseProducts() {
        System.out.println("\n--- All Products ---");
        System.out.printf("  %-10s | %-25s | %-8s | %-15s | %s%n",
            "ID", "Name", "Price", "Category", "Status");
        System.out.println("----------------------------------------------------------------------------------");
        for (Product p : products) {
            if (p != null) {
                p.displayProductInfo();
            }
        }
    }

    private static void browseProductsByCategory(String category) {
        System.out.println("\n--- Products in Category: " + category + " ---");
        Product[] categoryProducts = Product.getProductsByCategory(products, category);
        if (categoryProducts.length == 0) {
            System.out.println("No products found in this category.");
            return;
        }
        System.out.printf("  %-10s | %-25s | %-8s | %-15s | %s%n",
            "ID", "Name", "Price", "Category", "Status");
        System.out.println("----------------------------------------------------------------------------------");
        for (Product p : categoryProducts) {
            p.displayProductInfo();
        }
    }

    private static void addProductToCart(ShoppingCart cart) {
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Product productToAdd = Product.findProductById(products, productId);
        if (productToAdd != null) {
            cart.addProduct(productToAdd, quantity);
        } else {
            System.out.println("Product not found with ID: " + productId);
        }
    }

    private static void removeProductFromCart(ShoppingCart cart) {
        System.out.print("Enter Product ID to remove: ");
        String productId = scanner.nextLine();
        cart.removeProduct(productId);
    }
}
