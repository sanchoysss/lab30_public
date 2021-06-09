package by.cargo;

public class Car implements Cargo{

    private String name;
    private double weight;

    public Car(double weight) {
        name = this.getClass().getSimpleName();
        this.weight = weight;
    }

    public Car() {
        name = this.getClass().getSimpleName();
        weight = 0;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
