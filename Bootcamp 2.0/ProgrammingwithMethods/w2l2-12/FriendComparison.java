import java.util.Scanner;

public class FriendComparison {

    public static int findYoungest(int[] ages) {
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }

    public static int findTallest(double[] heights) {
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Input ages and heights
        for (int i = 0; i < 3; i++) {
            boolean validInput = false;
            while(!validInput) {
                System.out.print("Enter age for " + names[i] + ": ");
                if (input.hasNextInt()) {
                    ages[i] = input.nextInt();
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Enter an integer");
                    input.next();
                }
            }

            validInput = false;
            while(!validInput) {
                System.out.print("Enter height (in meters) for " + names[i] + ": ");
                if (input.hasNextDouble()) {
                    heights[i] = input.nextDouble();
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Enter a double");
                    input.next();
                }
            }
        }

        int youngestIndex = findYoungest(ages);
        int tallestIndex = findTallest(heights);

        System.out.println("\nYoungest friend: " + names[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest friend: " + names[tallestIndex] + " (Height: " + heights[tallestIndex] + " meters)");

        input.close();
    }
}