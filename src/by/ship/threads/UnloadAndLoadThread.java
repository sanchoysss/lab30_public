package by.ship.threads;

import by.cargo.Cargo;
import by.ship.Ship;
import by.ship.Status;

import java.util.ArrayList;
import java.util.Arrays;

public class UnloadAndLoadThread extends MyThread{

    private ArrayList<Cargo> cargo;

    public UnloadAndLoadThread(String name, Ship ship, Cargo... cargo) {
        super(name, ship);
        this.cargo = new ArrayList<>();
        this.cargo.addAll(Arrays.asList(cargo));
    }

    public UnloadAndLoadThread(Ship ship, Cargo... cargo) {
        super(ship);
        this.cargo = new ArrayList<>();
        this.cargo.addAll(Arrays.asList(cargo));
    }

    public static UnloadAndLoadThread createAndStart(String name, Ship ship, Cargo... cargo) {
        UnloadAndLoadThread thread = new UnloadAndLoadThread(name, ship, cargo);

        thread.getTHREAD().start();
        return thread;
    }

    public static UnloadAndLoadThread createAndStart(Ship ship, Cargo... cargo) {
        UnloadAndLoadThread thread = new UnloadAndLoadThread(ship, cargo);

        thread.getTHREAD().start();
        return thread;
    }

    @Override
    public void run() {
        System.out.println("Ship " + getSHIP().getId() + " is unloading and loading");
        getSHIP().updateStatus(Status.Loading_And_Unloading);
        try {
            Thread.sleep( (int) Math.max(getSHIP().getWeightOfACargo(), getWeightOfCargo()));
        } catch(InterruptedException exception) {
            System.out.println(exception);
        }
        System.out.println("Ship " + getSHIP().getId() +  " is loaded and ready for a departure");
        getSHIP().setCargo(cargo);
        getSHIP().updateStatus(Status.Free);
    }

    private double getWeightOfCargo() {
        double weight = 0;
        for (int i = 0; i < cargo.size(); weight += cargo.get(i++).getWeight());
        return weight;
    }
}
