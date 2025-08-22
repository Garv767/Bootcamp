import java.util.Scanner;


class Q1_temp_converter{
    public static void main(String[] args) {
        
    float farenheitResult ;

    Scanner calculate = new Scanner(System.in);

    System.out.print("Enter temperture in Celcuis: ");
        float celsius = calculate.nextFloat();


    farenheitResult = (celsius * 9/5) + 32 ; 

    System.out.println("The "+ celsius+" celsius is "+farenheitResult+ " Farenheit");

}
}
