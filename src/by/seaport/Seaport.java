package by.seaport;

import by.cargo.Cargo;
import by.exceptions.ShipIsEmptyException;
import by.ship.Ship;
import by.ship.threads.MyThread;

import java.util.ArrayList;

public class Seaport {
    private final static ArrayList<Marina> marinas = new ArrayList<>(0);
    private final static ArrayList<Ship> ships = new ArrayList<>(0);

    public static void addMarina() {
        marinas.add(new Marina());
    }

    public static void addMarina(Ship ship) {
        marinas.add(new Marina(Status.Busy, ship));
    }

    public static void addShip(Ship ship) {
        ship.updateStatus(by.ship.Status.Waiting);
        ships.add(ship);
    }

    public static void addShips(ArrayList<Ship> ships) {
        for (Ship ship : ships) {
            addShip(ship);
        }
    }

    public static int addShipToFreeMarina() {
        int freeMarina = checkMarinas();
        if (freeMarina != -1) {
            Ship ship = ships.remove(0);
            marinas.get(freeMarina).setShip(ship);
            return ship.getId();
        }
        return -1;
    }

    public static MyThread unloadShip(int shipId) throws ShipIsEmptyException {
        int marinasId = checkShipId(shipId);
        if (marinasId != -1) {
            return marinas.get(marinasId).unloadShip();
        }
        return null;
    }

    public static MyThread loadShip (int shipId, Cargo... cargos) {
        int marinasId = checkShipId(shipId);
        if (marinasId != -1) {
            return marinas.get(marinasId).loadShip(cargos);
        }
        return null;
    }

    public static MyThread unloadAndLoadShip (int shipId, Cargo... cargos) {
        int marinasId = checkShipId(shipId);
        if (marinasId != -1) {
            return marinas.get(marinasId).unloadAndLoadShip(cargos);
        }
        return null;
    }

    public static void departAllFreeShips() {
        for (int i = 0; i < marinas.size(); i++) {
            if (marinas.get(i).getShip().getStatus().equals(by.ship.Status.Free)) {
                marinas.get(i).departShip();
            }
        }
    }

    public static ArrayList<Ship> getShips() {
        return ships;
    }

    public static ArrayList<Marina> getMarinas() {
        return marinas;
    }

    private static int checkMarinas() {
        for (int i = 0; i < marinas.size(); i++) {
            if (marinas.get(i).getStatus().equals(Status.Free)) {
                return i;
            }
        }
        return -1;
    }

    private static int checkShipId(int id) {
        if (id < 0) {
            return -1;
        }
        for (int i = 0; i < marinas.size(); i++) {
            if (marinas.get(i).getShip().getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
