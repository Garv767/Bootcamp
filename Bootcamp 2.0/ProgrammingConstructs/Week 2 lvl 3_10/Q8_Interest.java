import java.util.Scanner;

public class Q8_Interest {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Principal amount: ");
        double principal = input.nextDouble();
        System.out.print("Enter the Rate of Interest: ");
        double rate = input.nextDouble();
        System.out.print("Enter the Time (in years): ");
        double time = input.nextDouble();
        // Calculate Simple Interest
        double simpleInterest = (principal * rate * time) / 100;
        // Print the result
        System.out.println("The Simple Interest is " + simpleInterest +
                           " for Principal " + principal + ", Rate of Interest " + rate +
                           " and Time " + time);
        input.close(); // Close the scanner
    }
}