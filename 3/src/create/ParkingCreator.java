package create;

import entity.Parking;
import entity.ParkingLot;

public class ParkingCreator {
    public static Parking create(int id, int size){
        Parking parking = new Parking(id, size);

        for (int i = 0; i < size; i++) {
            parking.addToParkLots(new ParkingLot(i, parking.getParkId()));
        }

        return parking;
    }
}
