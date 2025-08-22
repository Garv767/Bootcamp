import java.util.Scanner;


class Q3_SalaryCalculator{
    public static void main(String[] args) {     
    //float name 
    Scanner calculate = new Scanner(System.in);
    /*System.out.print("Enter employee name: \n");
        String name = calculate.nextLine(); */
    System.out.print("\n Enter employee salary: ");
        float salary = calculate.nextFloat();

    System.out.print("\n Enter employee bonus: ");
        float bonus = calculate.nextFloat();


    float total_sal = salary + bonus;
    System.out.println("The salary is INR "+ salary+" and bonus is INR "+bonus+ ". Hence Total Income is INR " + total_sal);

}
}
