
import java.util.Scanner;

class Q4{

    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);   
    System.out.print("Enter the distance in feets: ");
    double infeet =  input.nextDouble();

    double in_yards = infeet * 3;
    double in_miles = in_yards * 1760;



    System.out.println("The distance is " +in_yards+ " in yard & in miles is " +in_miles+ "\n");

}



}