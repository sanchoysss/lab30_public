package by.ship.threads;

import by.cargo.Cargo;
import by.ship.Ship;
import by.ship.Status;

import java.util.ArrayList;
import java.util.Arrays;

public class LoadThread extends MyThread{

    private ArrayList<Cargo> cargos;

    public LoadThread(String name, Ship ship, Cargo... cargos) {
        super(name, ship);
        this.cargos = new ArrayList<>();
        this.cargos.addAll(Arrays.asList(cargos));
    }

    public LoadThread(Ship ship, Cargo... cargos) {
        super(ship);
        this.cargos = new ArrayList<>();
        this.cargos.addAll(Arrays.asList(cargos));
    }

    public static LoadThread createAndStart(String name, Ship ship, Cargo... cargos) {
        LoadThread loadThread = new LoadThread(name, ship, cargos);

        loadThread.getTHREAD().start();
        return loadThread;
    }

    public static LoadThread createAndStart(Ship ship, Cargo... cargos) {
        LoadThread loadThread = new LoadThread(ship, cargos);

        loadThread.getTHREAD().start();
        return loadThread;
    }

    @Override
    public void run() {
        System.out.println("Ship " + getSHIP().getId() + " is loading.");
        getSHIP().updateStatus(Status.Loading);
        try {
            Thread.sleep((int) getWeightOfCargo());
        } catch(InterruptedException exception) {
            System.out.println(exception);
            return;
        }
        if (getSHIP().getWeightOfACargo() == 0) {
            getSHIP().setCargo(cargos);
        } else {
            getSHIP().addCargo(cargos);
        }
        System.out.println("Ship " + getSHIP().getId() + " is loaded.");
        getSHIP().updateStatus(Status.Free);
    }

    private double getWeightOfCargo() {
        double weight = 0;
        for (int i = 0; i < cargos.size(); weight += cargos.get(i++).getWeight());
        return weight;
    }
}
