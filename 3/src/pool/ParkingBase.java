package pool;

import entity.Parking;
import entity.ParkingLot;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingBase {
    static Logger logger = LogManager.getLogger();

    private ReentrantLock lock = new ReentrantLock();
    private ArrayList<Parking> parkingBase = new ArrayList<>();

    public ParkingBase(){}

    public void addParking(Parking park){
        parkingBase.add(park);
    }

    public ParkingLot getLot(long maxWaitMilliseconds) {
        logger.log(Level.DEBUG,"Car #" + Thread.currentThread().getId() + " tried to getLot");
        ParkingLot toReturn = null;
        for (Parking park : parkingBase) {
            ParkingLot lot = park.takeLot(maxWaitMilliseconds);
            if (lot != null){
                toReturn = lot;
                break;
            }
            else {
                logger.log(Level.INFO,"Car #" + Thread.currentThread().getId() + " -> timeout. Going to another parking.");
            }
        }
        return toReturn;
    }

    public boolean returnLot(ParkingLot lot){
        boolean toReturn = false;
        if (lock.tryLock()) {
            for (Parking park : parkingBase) {
                if (park.getParkId() == lot.getParkId()) {
                    park.returnLot(lot);
                }
            }
            toReturn = true;
            lock.unlock();
        }
        return toReturn;
    }
}
