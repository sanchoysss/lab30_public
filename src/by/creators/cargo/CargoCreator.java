package by.creators.cargo;


import by.cargo.Cargo;
import by.cargo.Car;
import by.cargo.Oil;
import by.cargo.Clothes;

import java.util.ArrayList;
import java.util.Random;

public class CargoCreator {

    public static ArrayList<Cargo> createCargo(int size) {
        ArrayList<Cargo> cargo = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            switch (random.nextInt(3)) {
                case 0 -> cargo.add(new Car());
                case 1 -> cargo.add(new Clothes());
                default -> cargo.add(new Oil());
            }
        }

        return cargo;
    }
}
