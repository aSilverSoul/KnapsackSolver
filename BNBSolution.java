import java.util.*;

public class BNBSolution {

    String message;
    public List<Item> items;
    public double weight;
    public double value;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(message);
        builder.append(": ");
        builder.append(value);
        builder.append(" ");
        builder.append(weight);
        builder.append("\n");

        Collections.sort(items, Item.byLabel());

        for (Item item : items) {
            builder.append(item.label);
            builder.append(" ");
        }

        return builder.toString();
    }
}