import java.util.*;

public abstract class BNBSolver {

    protected List<Item> items;
    protected int capacity;

    protected BNBSolver(List<Item> items, int capacity) {
        this.items = items;
        this.capacity = capacity;
    }

    public abstract BNBSolution solve();

    public double getWeight(List<Item> items) {
        double weight = 0;
        for (Item item : items) {
            weight += item.weight;
        }
        return weight;
    }

    public double getValue(List<Item> items) {
        double value = 0;
        for (Item item : items) {
            value += item.value;
        }
        return value;
    }
}