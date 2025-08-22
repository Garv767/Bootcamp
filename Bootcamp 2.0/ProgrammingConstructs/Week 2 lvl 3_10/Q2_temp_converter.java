import java.util.Scanner;


class Q2_temp_converter{
    public static void main(String[] args) {
        
    float celsiusResult;

    Scanner calculate = new Scanner(System.in);

    System.out.print("Enter temperture in Farenheit: ");
        float Farenheit = calculate.nextFloat();


    celsiusResult = (Farenheit - 32) * 5/9; 

    System.out.println("The "+ Farenheit+" farenheit is"+celsiusResult+ "celsius");

}
}
