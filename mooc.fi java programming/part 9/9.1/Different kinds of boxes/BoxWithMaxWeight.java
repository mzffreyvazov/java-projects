import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
    private ArrayList<Item> items;
    private int maxWeight;

    public BoxWithMaxWeight(int maxWeight) {
        this.items = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    @Override
    public void add(Item item) {
        int current = 0;
        for (Item it: this.items) {
            current += it.getWeight();
        }

        if (item.getWeight() <= maxWeight - current) {
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }
}

