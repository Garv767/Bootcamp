
import java.util.Scanner;

class Q1{
    public static void main(String[] args) {
      float add, subs, multi, div;

       // Creating Scanner class object
        Scanner calculate = new Scanner(System.in);

        // Enter first input
        System.out.print("Enter First Number: ");
        float number1 = calculate.nextFloat();
        //Enter second input
        System.out.println("Enter Second Number: ");ṇ
        float number2 = calculate.nextFloat();

        add = number1 + number2;
        subs = number2 - number1;
        multi = number1 * number2;
        div = number1/number2;
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+ number1+ "and "+ number2+ "is "+ add+", "+subs+", "+multi+", "+div);
      }


    }

