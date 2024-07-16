package FlightControl.domain;

public class Flight {
    private Airplane plane;
    private Place destination;
    private Place departure;


    public Flight(Airplane plane, Place destination, Place departure) {
        this.plane = plane;
        this.destination = destination;
        this.departure = departure;
    }

    public String getPlaneId() {
        return this.plane.getId();
    }

    public Place getDestination() {
        return destination;
    }

    public Place getDeparture() {
        return departure;
    }

    @Override
    public String toString() {
        // HA-LOL (42 capacity) (HEL-BAL)

        return String.format("%s (%d capacity) (%s-%s)", this.getPlaneId(), this.plane.getCapacity(), this.destination.getPoint(), this.departure.getPoint());
    }

    


}
