package entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pool.ParkingBase;

public class Car extends Thread {
    static Logger logger = LogManager.getLogger();
    static final int MILLISECONDS = 100;

    private boolean standing;
    private ParkingBase parkingBase;

    public Car(ParkingBase parkingBase){
        this.parkingBase = parkingBase;
        logger.log(Level.DEBUG,"Car #" + this.getId() + " is created");
    }

    public void run(){
        this.setName("Car #" + this.getId());
        ParkingLot lot = null;

        while (lot == null){
            logger.log(Level.DEBUG,"Try of getting lot. Car #" + this.getId());
            lot = parkingBase.getLot(MILLISECONDS);
        }
        logger.log(Level.INFO,"Car #" + this.getId() + " took lot №" + lot.getLotId() + ". Parking №" + lot.getParkId());
        standing = true;

        lot.using();

        standing = false;
        logger.log(Level.INFO,"Car #" + this.getId() + " : lot №" + lot.getLotId() + " is released. Parking №" + lot.getParkId());
        while (true){
            if (parkingBase.returnLot(lot)){
                break;
            }
        }
        logger.log(Level.DEBUG,"Car #" + this.getId() + " is terminated");
    }

    public boolean isStanding(){
        return standing;
    }
}
