public class MisplacingBox extends Box {
    public MisplacingBox() {
    }

    @Override
    public void add(Item item) {
        // Items are added but misplaced, so no storage is necessary
    }

    @Override
    public boolean isInBox(Item item) {
        return false;
    }
}