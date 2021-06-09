package by.seaport;

import by.cargo.Cargo;

import by.ship.Priority;
import by.ship.Ship;

import by.ship.threads.LoadThread;
import by.ship.threads.MyThread;
import by.ship.threads.UnloadThread;
import by.ship.threads.UnloadAndLoadThread;

import by.exceptions.ShipIsEmptyException;


public class Marina {

    private Status status;
    private Ship ship;
    private MyThread myThread;

    public Marina(Status status, Ship ship) {
        this.status = status;
        this.ship = ship;
    }

    public Marina() {
        status = Status.Free;
        ship = new Ship();
    }

    public Ship getShip() {
        return ship;
    }

    public MyThread loadShip(Cargo... cargos) {
        myThread = new LoadThread(ship, cargos);
        myThread.getTHREAD().start();
        if (myThread.getSHIP().getPriority().equals(Priority.High)) {
            myThread.getTHREAD().setPriority(Thread.NORM_PRIORITY + 2);
        } else if (myThread.getSHIP().getPriority().equals(Priority.Low)) {
            myThread.getTHREAD().setPriority(Thread.NORM_PRIORITY - 2);
        }
        return myThread;
    }

    public MyThread unloadShip() throws ShipIsEmptyException{
        if (ship.getWeightOfACargo() == 0) {
            throw new ShipIsEmptyException("There is nothing to unload in ship " + ship.getId());
        }
        myThread = new UnloadThread(ship);
        myThread.getTHREAD().start();
        if (myThread.getSHIP().getPriority().equals(Priority.High)) {
            myThread.getTHREAD().setPriority(Thread.NORM_PRIORITY + 2);
        } else if (myThread.getSHIP().getPriority().equals(Priority.Low)) {
            myThread.getTHREAD().setPriority(Thread.NORM_PRIORITY - 2);
        }
        return myThread;
    }

    public MyThread unloadAndLoadShip(Cargo... cargo) {
        if (ship.getWeightOfACargo() == 0) {
            System.out.println("There is nothing to unload in ship " + ship.getId());
            myThread = new LoadThread(ship, cargo);
        } else {
            myThread = new UnloadAndLoadThread(ship, cargo);
        }
        myThread.getTHREAD().start();
        if (myThread.getSHIP().getPriority().equals(Priority.High)) {
            myThread.getTHREAD().setPriority(Thread.NORM_PRIORITY + 2);
        } else if (myThread.getSHIP().getPriority().equals(Priority.Low)) {
            myThread.getTHREAD().setPriority(Thread.NORM_PRIORITY - 2);
        }
        return myThread;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
        status = Status.Busy;
    }

    public void departShip() {
        ship = new Ship();
        status = Status.Free;
    }

    public Status getStatus() {
        return status;
    }
}
