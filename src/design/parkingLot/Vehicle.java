package design.parkingLot;

import java.util.ArrayList;

public abstract class Vehicle {

    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();

    protected String licensePlate;

    protected int spotsNeeded;
    protected VehicleType type;

    public abstract boolean canFitInSpot(ParkingSpot spot);

    public void clearSpots() {
    }

    public void parkinSpot(ParkingSpot s) {
        parkingSpots.add(s);
    }


}
