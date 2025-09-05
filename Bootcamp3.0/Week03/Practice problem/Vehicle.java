public class Vehicle {
    // TODO: Create protected instance variables:
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;

    // TODO: Create constructor
    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    // TODO: Create common methods:
    public void startVehicle() {
        if (fuelLevel > 0) {
            System.out.println(make + " " + model + " started.");
        } else {
            System.out.println(make + " " + model + " cannot start. No fuel.");
        }
    }

    public void stopVehicle() {
        System.out.println(make + " " + model + " stopped.");
    }

    public void refuel(double amount) {
        if (amount > 0) {
            fuelLevel += amount;
            System.out.println(make + " " + model + " refueled with " + amount + " gallons.");
        }
    }

    public void displayVehicleInfo() {
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year + ", Fuel: " + fuelLevel + " gallons.");
    }

    public static void main(String[] args) {
        // TODO: Create different types of vehicles
        Vehicle car = new car1("Honda", "Civic", 2022, 10.5, 4);
        Vehicle truck = new Truck("Ford", "F-150", 2020, 25.0, 1.5);
        Vehicle motorcycle = new Motorcycle("Harley-Davidson", "Street 750", 2019, 3.0, false);

        // TODO: Create an array of Vehicle objects
        Vehicle[] vehicles = {car, truck, motorcycle};

        // TODO: Demonstrate polymorphic behavior
        System.out.println("--- Displaying All Vehicles ---");
        for (Vehicle v : vehicles) {
            v.displayVehicleInfo();
            v.startVehicle();
            System.out.println();
        }

        System.out.println("--- Refueling all vehicles ---");
        for (Vehicle v : vehicles) {
            v.refuel(5.0);
            v.displayVehicleInfo();
        }
    }
}
