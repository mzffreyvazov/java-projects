package FlightControl.logic;
import java.util.HashMap;
import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.Place;

public class FlightControl {
    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Flight> flights;
    private HashMap<String, Place> places;

    public FlightControl() {
        airplanes = new HashMap<>();
        flights = new HashMap<>();
        places = new HashMap<>();
    }

    public void addAirplane(String id, Integer capacity) {
        Airplane airplane = new Airplane(id, capacity);
        this.airplanes.put(id, airplane);
    }

    // Check if there is a corresponding airplane for the user to add the flight
    public boolean checkAirplane(String airplaneID) {

        if (this.airplanes.containsKey(airplaneID)) {
            return true;
        }
        return false;
    }

    public void addFlight(String airplaneId, String departureId, String destinationID) {
        
        // Check if there is an airplane with airplaneID and then add the flight
        try {
            if (checkAirplane(airplaneId)) {
                int capacity = this.airplanes.get(airplaneId).getCapacity();
                // Airplane plane = new Airplane(airplaneId, capacity);

                Flight flight = new Flight(new Airplane(airplaneId, capacity), new Place(departureId), new Place(destinationID));
                this.flights.put(departureId, flight);
            }
        } catch (Exception e) {
            System.out.println("The airplane doesn't exist. Try again");
        }

    }

    public void printAirplanes() {

        for (Airplane airplane: this.airplanes.values()) {
            System.out.println(airplane);
        }
    }

    public void printFlights() {
        for (Flight flight: this.flights.values()) {
            System.out.println(flight);;
        }
    }

    public String printAirplaneDetails(String ID) { 
        return this.airplanes.get(ID).toString();
    }



    // Implement the methods here

    
}
