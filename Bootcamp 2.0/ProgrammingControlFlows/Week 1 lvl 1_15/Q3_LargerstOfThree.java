import java.util.Scanner;

public class Q3_LargestOfThree {
 public static void main(String args[])
{
 int number1,number2,number3;

 Scanner input = new Scanner(System.in);
 System.out.println("Enter 3 integers");

 number1=input.nextInt();
 number2=input.nextInt(); 
 number3=input.nextInt();

 if(number1>number2 && number1>number3)
        System.out.println ("Is the first number the largest? Yes\n"+"Is the second number the largest? No\n"+"Is the third number the largest? No");
    
 else if(number2>number1 && number2>number3) 
        System.out.println("Is the first number the largest? No\n"+"Is the second number the largest? Yes\n"+"Is the third number the largest? No");
 
 else if(number3>number1 && number3>number2)
        System.out.println("Is the first number the largest? No\n"+"Is the second number the largest? No\n"+"Is the third number the largest? Yes");
 
}
}