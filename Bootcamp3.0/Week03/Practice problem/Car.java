public class Car {
    String brand;
    String model;
    int year;
    String color;
    boolean isRunning;

    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false;
    }
    // Methods
    public void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " engine started.");
    }
    public void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " engine stopped.");
    }
    public void displayInfo() {
        System.out.println("Car: " + brand + " " + model + ", Year: " + year + ", Color: " + color + ", Running: " + isRunning);
    }
    public int getAge() {
        int currentYear = 2025;
        return currentYear - year;
    }
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", 2018, "Red");
        Car car2 = new Car("Honda", "Civic", 2020, "Blue");
        Car car3 = new Car("Tesla", "Model 3", 2022, "White");
        car1.startEngine();
        car2.displayInfo();
        car3.stopEngine();
        System.out.println("Car1 Age: " + car1.getAge() + " years");
        System.out.println("Car2 Age: " + car2.getAge() + " years");
        System.out.println("Car3 Age: " + car3.getAge() + " years");
    }
}
