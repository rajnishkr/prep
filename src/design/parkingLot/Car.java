package design.parkingLot;

public class Car extends  Vehicle{

    Car(){
        type= VehicleType.Compact;
        spotsNeeded = 3;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        //TODO implement can fit
        return false;
    }
}
