package run;

/*
    3. Автостоянка.
       Доступно несколько машиномест.
       На одном месте может находиться только один автомобиль.
       Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.
 */

import create.ParkingCreator;
import entity.Car;
import pool.ParkingBase;

public class Main {
    public static void main(String[] args) {
        ParkingBase parkingBase = new ParkingBase();
        parkingBase.addParking(ParkingCreator.create(0, 3));
        parkingBase.addParking(ParkingCreator.create(1, 2));
        parkingBase.addParking(ParkingCreator.create(2, 4));

        for (int i = 0; i < 10; i++) {
            new Car(parkingBase).start();
        }
    }
}
