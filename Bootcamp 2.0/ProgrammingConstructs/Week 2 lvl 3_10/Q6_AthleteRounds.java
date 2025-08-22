import java.util.Scanner;

public class Q6_AthleteRounds {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length of side 1 (in meters):");
        double side1 = input.nextDouble();
        System.out.println("Enter the length of side 2 (in meters):");
        double side2 = input.nextDouble();
        System.out.println("Enter the length of side 3 (in meters):");
        double side3 = input.nextDouble();
        // Calculate the perimeter of the triangle
        double perimeter = side1 + side2 + side3;
        // Convert 5 km to meters
        double distanceInMeters = 5 * 1000; // 5 km * 1000 meters/km
        // Calculate the number of rounds
        double rounds = distanceInMeters / perimeter;
        // Print the result, rounding to the nearest whole number for practical rounds
        System.out.println("The total number of rounds the athlete will run is " + Math.round(rounds) + " to complete 5 km");
        input.close(); // Close the scanner to release resources
    }
}
