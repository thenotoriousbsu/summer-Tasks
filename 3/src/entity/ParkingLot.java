package entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class ParkingLot {
    static Logger logger = LogManager.getLogger();

    private int lotId;
    private int parkId;

    public ParkingLot(int lotId, int parkId){
        super();
        this.lotId = lotId;
        this.parkId = parkId;
    }

    public int getLotId() {
        return lotId;
    }

    public int getParkId() {
        return parkId;
    }

    public void using(){
        logger.log(Level.DEBUG,"LOT #" + lotId + " using by Car #" + Thread.currentThread().getId());
        try{
            TimeUnit.MILLISECONDS.sleep(new java.util.Random().nextInt(200));
        } catch (InterruptedException e){
            logger.log(Level.ERROR, e);
        }
    }

    @Override
    public String toString(){
        return "LOT #" + lotId + " PARK_ID #" + parkId;
    }
}
