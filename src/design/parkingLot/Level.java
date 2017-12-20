package design.parkingLot;

public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0;
    private static final int SPOTS_PER_ROW = 10;

    public Level(int flr, int numberSpots) { //TODO
         }

        public int getAvailableSpots() {
            return availableSpots;
        }

        public boolean parkVehicle (Vehicle vehicle){
            return false;
        }

        private boolean parkStartingAtSpot ( int num, Vehicle v){
            return false;
        }

        private int findAvailableSpots (Vehicle vehicle){
            return 0;
        }

        public void spotFreed () {
            availableSpots++;
        }
    }
