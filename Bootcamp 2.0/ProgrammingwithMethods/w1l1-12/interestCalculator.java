import java.util.Scanner;

public class interestCalculator{

    double Calculate(double P, float R, int T) {
        double interest = (P*R*T)/100;
        return (interest);
    };
    
    void display(double interest){
        System.out.println("The Interest is: " + interest);
    };
    

    public static void main(String[] args) {
        interestCalculator INTREST = new interestCalculator();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Principle Amount: ");
        double Principle = input.nextDouble();
        System.out.println("Enter Rate of Interest: ");
        float Rate = input.nextFloat();
        System.out.println("Enter Time Duration: ");
        int Time = input.nextInt();

        double interest = INTREST.Calculate(Principle, Rate, Time);
        INTREST.display(interest);

        input.close();
    }
};
