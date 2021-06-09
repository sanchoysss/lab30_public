package by.ship.threads;

import by.ship.Ship;
import by.ship.Status;

import java.util.ArrayList;

public class UnloadThread extends MyThread{


    public UnloadThread(String name, Ship ship) {
        super(name, ship);
    }

    public UnloadThread(Ship ship) {
        super(ship);
    }

    public static UnloadThread createAndStart(String name, Ship ship) {
        UnloadThread unloadThread = new UnloadThread(name, ship);

        unloadThread.getTHREAD().start();
        return unloadThread;
    }

    public static UnloadThread createAndStart(Ship ship) {
        UnloadThread unloadThread = new UnloadThread(ship);

        unloadThread.getTHREAD().start();
        return unloadThread;
    }

    @Override
    public void run() {
        System.out.println("Ship " + getSHIP().getId() + " is unloading.");
        getSHIP().updateStatus(Status.Unloading);
        try {
            Thread.sleep((int) getSHIP().getWeightOfACargo());
        } catch(InterruptedException exception) {
            System.out.println(exception);
            return;
        }
        getSHIP().setCargo(new ArrayList<>(0));
        System.out.println("Ship " + getSHIP().getId() + " is unloaded.");
        getSHIP().updateStatus(Status.Free);
    }
}
