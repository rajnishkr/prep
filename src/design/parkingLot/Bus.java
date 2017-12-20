package design.parkingLot;

public class Bus extends Vehicle {

    public Bus() {
        spotsNeeded = 5;
        type = VehicleType.Large;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        //TODO impl
        return false;
    }
}
