import java.util.Scanner;

public class youngestTallest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Input ages and heights
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for " + names[i] + ": ");
            if (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer for age.");
                input.next();
                i--;
                continue;
            }
            ages[i] = input.nextInt();

            System.out.print("Enter height for " + names[i] + " (in meters): ");
            if (!input.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a double for height.");
                input.next();
                i--;
                continue;
            }
            heights[i] = input.nextDouble();
        }

        // Find youngest
        int youngestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }

        // Find tallest
        int tallestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Display results
        System.out.println("\nYoungest friend: " + names[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest friend: " + names[tallestIndex] + " (Height: " + heights[tallestIndex] + " meters)");

        input.close();
    }
}