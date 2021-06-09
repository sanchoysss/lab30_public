package by.creators.cargo;

import by.cargo.Cargo;

import java.util.ArrayList;
import java.util.Random;

public class CargoInitializer {

    public static final double WEIGHT_FOR_CLOTHES[] = {200, 400, 600, 800, 1000};

    public static final double WEIGHT_FOR_CARS[] = {1000, 2000, 3000, 4000, 5000};

    public static final double  WEIGHT_FOR_OIL[] = {500, 1000, 1500, 2000, 2500};

    public static void initializeCargo(ArrayList<Cargo> cargo) {
        Random random = new Random();
        for (Cargo value : cargo) {
            if (value.getClass().getSimpleName().equals("Car")) {
                value.setWeight(WEIGHT_FOR_CARS[random.nextInt(WEIGHT_FOR_CARS.length)]);
            } else if (value.getClass().getSimpleName().equals("Oil")) {
                value.setWeight(WEIGHT_FOR_OIL[random.nextInt(WEIGHT_FOR_OIL.length)]);
            } else {
                value.setWeight(WEIGHT_FOR_CLOTHES[random.nextInt(WEIGHT_FOR_CLOTHES.length)]);
            }
        }
    }
}
