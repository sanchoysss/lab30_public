package by.ship.threads;

import by.ship.Ship;

public abstract class MyThread implements Runnable {
    private final Thread THREAD;
    private final Ship SHIP;

    public MyThread(String name, Ship ship) {
        THREAD = new Thread(this, name);
        SHIP = ship;
    }

    public MyThread(Ship ship) {
        THREAD = new Thread(this);
        SHIP = ship;
    }

    public Thread getTHREAD() {
        return THREAD;
    }

    public Ship getSHIP() {
        return SHIP;
    }
}
