package design.parkingLot;

public class Bike extends Vehicle {

    Bike(){
        spotsNeeded=1;
        type = VehicleType.MotarCycle;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        //TODO
        return false;
    }
}
