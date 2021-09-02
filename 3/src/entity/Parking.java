package entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parking {
    static Logger logger = LogManager.getLogger();

    private int parkId;
    private int parkSize;
    private Queue<ParkingLot> lots = new ConcurrentLinkedQueue<>();
    private Semaphore semaphore;

    public Parking(int parkId, int parkSize){
        this.parkId = parkId;
        this.parkSize = parkSize;
        this.semaphore = new Semaphore(parkSize, true);
    }

    public int getParkId() {
        return parkId;
    }

    public Queue<ParkingLot> getLots(){
        Queue<ParkingLot> lotsClone = new LinkedList<>();
        lotsClone.addAll(lots);
        return lotsClone;
    }

    public void addToParkLots(ParkingLot lot){
        if (parkSize >= 0){
            lots.add(lot);
            parkSize--;
        }
    }

    public ParkingLot takeLot(long maxWaitMillis){
        ParkingLot toReturn = null;
        try {
            if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                logger.log(Level.DEBUG,"Car #" + Thread.currentThread().getId() + " pull from park #" + Parking.this.parkId);
                ParkingLot lot = lots.poll();
                logger.log(Level.DEBUG,"Car #" + Thread.currentThread().getId() +  " pull " + lot);
                toReturn = lot;
            }
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, e);
        }
        return toReturn;
    }

    public void returnLot(ParkingLot lot){
        lots.add(lot);
        semaphore.release();
    }
}
