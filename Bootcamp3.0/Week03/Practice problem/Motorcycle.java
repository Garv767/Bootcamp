public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String make, String model, int year, double fuelLevel, boolean hasSidecar) {
        super(make, model, year, fuelLevel);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Has sidecar: " + hasSidecar);
    }
}