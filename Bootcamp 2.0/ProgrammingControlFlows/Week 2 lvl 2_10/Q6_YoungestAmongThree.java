import java.util.Scanner;

public class Q6_YoungestAmongThree {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input for Amar
        System.out.print("Enter Amar's age: ");
        int amarAge = input.nextInt();
        System.out.print("Enter Amar's height (in cm): ");
        double amarHeight = input.nextDouble();

        // Input for Akbar
        System.out.print("Enter Akbar's age: ");
        int akbarAge = input.nextInt();
        System.out.print("Enter Akbar's height (in cm): ");
        double akbarHeight = input.nextDouble();

        // Input for Anthony
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = input.nextInt();
        System.out.print("Enter Anthony's height (in cm): ");
        double anthonyHeight = input.nextDouble();

        // Find the youngest friend
        String youngestFriend;
        int youngestAge = Math.min(amarAge, Math.min(akbarAge, anthonyAge)); // Efficiently find the minimum

        if (youngestAge == amarAge) {
            youngestFriend = "Amar";
        } else if (youngestAge == akbarAge) {
            youngestFriend = "Akbar";
        } else {
            youngestFriend = "Anthony";
        }

        System.out.println("The youngest friend is " + youngestFriend + " with age " + youngestAge + ".");


        // Find the tallest friend
        String tallestFriend;
        double tallestHeight = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));

        if (tallestHeight == amarHeight) {
            tallestFriend = "Amar";
        } else if (tallestHeight == akbarHeight) {
            tallestFriend = "Akbar";
        } else {
            tallestFriend = "Anthony";
        }

        System.out.println("The tallest friend is " + tallestFriend + " with height " + tallestHeight + " cm.");

        input.close();
    }
}