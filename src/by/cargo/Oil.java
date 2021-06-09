package by.cargo;

public class Oil implements Cargo{
    private String name;
    private double weight;

    public Oil(double weight) {
        name = this.getClass().getSimpleName();
        this.weight = weight;
    }

    public Oil() {
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
        return "Oil{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
