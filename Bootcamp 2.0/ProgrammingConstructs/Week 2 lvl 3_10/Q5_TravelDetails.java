import java.util.Scanner; // Import Scanner class for user input

public class Q5_TravelDetails {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        // Create Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Prompt user to enter cities
        System.out.print("Enter your starting city: ");
        String fromCity = scanner.nextLine();
        System.out.print("Enter the city you are traveling via: ");
        String viaCity = scanner.nextLine();
        System.out.print("Enter your destination city: ");
        String toCity = scanner.nextLine();

        // Prompt user to enter distances in miles
        System.out.print("Enter the distance from starting city to via city (in miles): ");
        double fromToVia = scanner.nextDouble();
        System.out.print("Enter the distance from via city to destination city (in miles): ");
        double viaToFinalCity = scanner.nextDouble();

        // Calculate total distance
        double totalDistance = fromToVia + viaToFinalCity;

        // Prompt user to enter time taken
        System.out.print("Enter the total time taken (in hours): ");
        double timeTaken = scanner.nextDouble();

        // Prompt user to enter fee and discount percent
        System.out.print("Enter the fee amount: ");
        double fee = scanner.nextDouble();
        System.out.print("Enter the discount percentage: ");
        double discountPercent = scanner.nextDouble();

        // Calculate discount and final fee
        double discountAmount = (fee * discountPercent) / 100;
        double finalFee = fee - discountAmount;

        // Display the results
        System.out.println("Traveler Name: " + name);
        System.out.println("Route: " + fromCity + " -> " + viaCity + " -> " + toCity);
        System.out.println("Total Distance: " + totalDistance + " miles");
        System.out.println("Total Time Taken: " + timeTaken + " hours");
        System.out.println("The results of Int Operations are " + fee + ", " + discountAmount + ", and " + finalFee);

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}