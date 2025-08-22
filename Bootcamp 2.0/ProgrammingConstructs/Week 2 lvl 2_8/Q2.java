import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base of the triangle in inches: ");
        double baseInches = scanner.nextDouble();

        System.out.print("Enter the height of the triangle in inches: ");
        double heightInches = scanner.nextDouble();

        double areaInSquareInches = 0.5 * baseInches * heightInches;

        double areaInSquareCentimeters = areaInSquareInches * 6.4516;

        System.out.println("Area of the triangle:");
        System.out.printf("In square inches: %.2f%n", areaInSquareInches);
        System.out.printf("In square centimeters: %.2f%n", areaInSquareCentimeters);
    }
}
