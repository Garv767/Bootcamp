import java.util.Scanner;

public class Q6_MeanHeight {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] heights = new double[11];
        double sum = 0;

        System.out.println("Enter the heights of 11 players (in meters):");

        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height: ");
            if (!input.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid height (in meters).");
                input.next(); // Clear invalid input
                i--; // Allow re-entry for this index.
                continue;
            }
            heights[i] = input.nextDouble();
            sum += heights[i];
        }

        double meanHeight = sum / heights.length;

        System.out.printf("Mean height of players: %.2f meters\n", meanHeight);

        input.close();
    }
}