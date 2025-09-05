import java.util.UUID;

public class Vehicle {
    // a. Private instance variables
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;
    private int totalRentalDays; // For this specific vehicle
    private double totalRentalRevenue; // For this specific vehicle

    // b. Static variables
    private static int totalVehicles = 0;
    private static double totalRevenue = 0.0;
    private static String companyName;
    private static int totalRentalDaysAllVehicles = 0;

    // c. Create a constructor
    public Vehicle(String brand, String model, double rentPerDay) {
        this.vehicleId = UUID.randomUUID().toString();
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        this.totalRentalDays = 0;
        this.totalRentalRevenue = 0.0;
        totalVehicles++;
    }

    // d. Static method: setCompanyName
    public static void setCompanyName(String name) {
        companyName = name;
    }

    // d. Static method: getTotalRevenue
    public static double getTotalRevenue() {
        return totalRevenue;
    }

    // d. Static method: getAverageRentPerDay
    public static double getAverageRentPerDay() {
        if (totalRentalDaysAllVehicles == 0) {
            return 0.0;
        }
        return totalRevenue / totalRentalDaysAllVehicles;
    }

    // d. Static method: displayCompanyStats
    public static void displayCompanyStats() {
        System.out.println("----------------------------------------");
        System.out.println("Company: " + companyName);
        System.out.println("Total Vehicles: " + totalVehicles);
        System.out.printf("Total Revenue: $%.2f%n", totalRevenue);
        System.out.printf("Average Rent Per Day: $%.2f%n", getAverageRentPerDay());
        System.out.println("Total Rental Days: " + totalRentalDaysAllVehicles);
        System.out.println("----------------------------------------");
    }

    // e. Method: calculateRent(int days)
    public double calculateRent(int days) {
        double rentalAmount = rentPerDay * days;
        totalRevenue += rentalAmount; // Update static revenue
        totalRentalDaysAllVehicles += days; // Update static rental days
        this.totalRentalDays += days; // Update instance rental days
        this.totalRentalRevenue += rentalAmount; // Update instance revenue
        return rentalAmount;
    }

    // c. Instance method: rentVehicle(int days)
    public void rentVehicle(int days) {
        if (isAvailable && days > 0) {
            double amount = calculateRent(days);
            isAvailable = false;
            System.out.printf("Rented %s %s for %d days. Total cost: $%.2f%n", brand, model, days, amount);
        } else if (!isAvailable) {
            System.out.println("Sorry, " + brand + " " + model + " is currently not available.");
        } else {
            System.out.println("Invalid rental duration.");
        }
    }

    // c. Instance method: returnVehicle()
    public void returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(brand + " " + model + " has been returned and is now available.");
        } else {
            System.out.println(brand + " " + model + " was not rented out.");
        }
    }

    // f. Method: displayVehicleInfo()
    public void displayVehicleInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.printf("Rent Per Day: $%.2f%n", rentPerDay);
        System.out.println("Status: " + (isAvailable ? "Available" : "Not Available"));
        System.out.println("Individual Rental History:");
        System.out.println("  Total Days Rented: " + totalRentalDays);
        System.out.printf("  Total Revenue Generated: $%.2f%n", totalRentalRevenue);
        System.out.println("----------------------------------------");
    }

    // g. Main method
    public static void main(String[] args) {
        // TODO: Set company name using a static method
        Vehicle.setCompanyName("Premium Rentals");

        // TODO: Create multiple vehicle objects
        Vehicle car1 = new Vehicle("Toyota", "Camry", 50.0);
        Vehicle car2 = new Vehicle("Honda", "Accord", 60.0);
        Vehicle truck1 = new Vehicle("Ford", "F-150", 100.0);
        System.out.println();

        // Demonstrate initial vehicle info (instance members)
        car1.displayVehicleInfo();
        car2.displayVehicleInfo();
        truck1.displayVehicleInfo();

        // TODO: Show how static members are shared across all objects
        System.out.println("--- Initial Company Statistics ---");
        Vehicle.displayCompanyStats();
        
        // TODO: Perform some rental transactions
        System.out.println("--- Rental Transactions ---");
        car1.rentVehicle(5);
        car2.rentVehicle(3);
        car1.rentVehicle(2); // Should fail as it's not available
        truck1.rentVehicle(7);
        System.out.println();

        // TODO: Show updated static members
        System.out.println("--- Updated Company Statistics (shared static members) ---");
        Vehicle.displayCompanyStats();
        System.out.println();

        // TODO: Show updated instance members (unique to each object)
        System.out.println("--- Individual Vehicle Info (unique instance members) ---");
        car1.displayVehicleInfo();
        car2.displayVehicleInfo();
        truck1.displayVehicleInfo();
        System.out.println();

        // TODO: Return a vehicle
        System.out.println("--- Returning a Vehicle ---");
        car1.returnVehicle();
        System.out.println();
        car1.displayVehicleInfo();
    }
}
