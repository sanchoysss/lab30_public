package by.creators.ship;

import by.cargo.Cargo;
import by.ship.Ship;

import by.creators.cargo.CargoInitializer;
import by.creators.cargo.CargoCreator;

import by.ship.Priority;

import java.util.ArrayList;
import java.util.Random;

public class ShipCreator {

    public static ArrayList<Ship> createShips(int size) {
        Random random = new Random();
        ArrayList<Ship> ships = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Cargo> cargo = CargoCreator.createCargo(random.nextInt(10));
            CargoInitializer.initializeCargo(cargo);
            Priority priority;
            switch (random.nextInt(2)) {
                case 0 -> priority = Priority.High;
                case 1 -> priority = Priority.Normal;
                default -> priority = Priority.Low;
            }
            ships.add(new Ship(priority, cargo));
        }
        return ships;
    }
}
