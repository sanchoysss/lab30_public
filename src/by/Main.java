package by;

import by.creators.ship.ShipCreator;
import by.exceptions.ShipIsEmptyException;
import by.seaport.Seaport;
import by.ship.Ship;
import by.ship.threads.MyThread;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        ArrayList<Ship> ships = ShipCreator.createShips(15);
        ArrayList<MyThread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Seaport.addMarina();
        }

        Seaport.addShips(ships);
        while(Seaport.getShips().size() != 0) {
            int id = Seaport.addShipToFreeMarina();
            if (id != -1) {
                switch(random.nextInt(3)) {
                    case 0:
                        threads.add(Seaport.loadShip(id));
                        break;
                    case 1:
                        try {
                            threads.add(Seaport.unloadShip(id));
                        } catch (ShipIsEmptyException exception) {
                            System.out.println(exception);
                        }
                        break;
                    default:
                        threads.add(Seaport.unloadAndLoadShip(id));
                        break;
                }
            }
            Seaport.departAllFreeShips();
        }
        for (MyThread thread : threads) {
            try {
                thread.getTHREAD().join();
            } catch (InterruptedException exception) {
                System.out.println(exception);
            }
        }
    }
}
