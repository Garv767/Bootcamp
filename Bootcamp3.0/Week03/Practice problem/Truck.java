public class Truck extends Vehicle {
    private double cargoCapacity; // In tons

    public Truck(String make, String model, int year, double fuelLevel, double cargoCapacity) {
        super(make, model, year, fuelLevel);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Cargo Capacity: " + cargoCapacity + " tons");
    }
}