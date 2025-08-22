import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    

        System.out.print("Enter the side of the square: ");
        double side = scanner.nextDouble();


        double perimeter = side * 4;

        System.out.println("The length of the side is "+side+"whose perimeter is "+ perimeter);
    
    }
}
