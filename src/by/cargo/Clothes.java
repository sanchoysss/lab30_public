package by.cargo;

public class Clothes implements Cargo{
    private String name;
    private double weight;

    public Clothes(double weight) {
        name = this.getClass().getSimpleName();
        this.weight = weight;
    }

    public Clothes() {
        name = this.getClass().getSimpleName();
        this.weight = 0;
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
        return "Clothes{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
