package design.parkingLot;


public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleType spotSize;
    private int row;
    private int spotNumber;
    private Level level;

    public ParkingSpot(Level lvl, int r, int n, VehicleType s) {
        //TODO

    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        //TODO
        return true;
    }

    public boolean park(Vehicle v) {
        return false;
    }

    public int getRow() {
        return row;
    }


    public int getSpotNumber() {
        return spotNumber;
    }

    public void removeVehicle() {
        //TODO
    }
}
