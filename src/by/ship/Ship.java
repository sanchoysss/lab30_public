package by.ship;

import java.util.ArrayList;
import java.util.Arrays;

import by.cargo.Cargo;

public class Ship {
    private ArrayList<Cargo> cargo;
    private Status status;
    private Priority priority;
    private int id;
    private static int shipId = 0;

    public Ship(Status status, Priority priority, Cargo... cargo) {
        this.cargo = new ArrayList<>();
        this.cargo.addAll(Arrays.asList(cargo));
        this.status = status;
        this.priority = priority;
        id = shipId++;
    }

    public Ship(Status status, ArrayList<Cargo> cargo, Priority priority) {
        this.cargo = new ArrayList<>(cargo.size());
        this.cargo.addAll(cargo);
        this.status = status;
        this.priority = priority;
        id = shipId++;
    }

    public Ship(Priority priority, Cargo... cargo) {
        this.cargo = new ArrayList<>();
        this.cargo.addAll(Arrays.asList(cargo));
        this.status = Status.Waiting;
        this.priority = priority;
        this.id = shipId++;
    }

    public Ship(Priority priority, ArrayList<Cargo> cargo) {
        this.cargo = new ArrayList<>();
        this.cargo.addAll(cargo);
        this.status = Status.Waiting;
        this.priority = priority;
        this.id = shipId++;
    }

    public Ship() {
        this.cargo = new ArrayList<>();
        status = Status.Absent;
        priority = Priority.Normal;
        id = shipId++;
    }

    public void addCargo(Cargo... cargo) {
        this.cargo.addAll(Arrays.asList(cargo));
    }

    public void addCargo(ArrayList<Cargo> cargo) {
        this.cargo.addAll(cargo);
    }

    public void updateStatus(Status status) {
        this.status = status;
    }

    public ArrayList<Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(ArrayList<Cargo> cargo) {
        this.cargo = cargo;
    }

    public double getWeightOfACargo() {
        double weight = 0;
        for (int i = 0; i < cargo.size(); weight += cargo.get(i++).getWeight());
        return weight;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "cargo=" + cargo +
                ", status=" + status +
                ", priority=" + priority +
                ", id=" + id +
                '}';
    }
}
