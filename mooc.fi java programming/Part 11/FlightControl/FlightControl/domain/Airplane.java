package FlightControl.domain;

public class Airplane {
    private String id;
    private int capacity;

    public Airplane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    } 

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return String.format("%s (%d capacity)", this.id, this.capacity);
    }


}
