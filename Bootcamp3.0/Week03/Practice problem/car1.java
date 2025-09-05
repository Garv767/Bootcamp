public class car1 extends Vehicle {
    private int numDoors;

    public car1(String make, String model, int year, double fuelLevel, int numDoors) {
        super(make, model, year, fuelLevel);
        this.numDoors = numDoors;
    }

    // You can override methods to provide specialized behavior
    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo(); // Call parent method
        System.out.println("Number of doors: " + numDoors);
    }
}