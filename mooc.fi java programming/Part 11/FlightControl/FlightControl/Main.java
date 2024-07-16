package FlightControl;
import java.util.Scanner;
import FlightControl.logic.FlightControl;
import FlightControl.ui.TextInterface;

public class Main {

    public static void main(String[] args) {
        // Write the main program here. It is useful to create some classes of your own.
        TextInterface textInterface = new TextInterface();
        

        // Part 1: Aiport Asset Control
        System.out.println("\nAirport Asset Control");
        System.out.println("--------------------");
        System.out.println();

        textInterface.assetControl();
        System.out.println();

        // Part 2: Flight Control
        System.out.println("\nFlight Control");
        System.out.println("--------------------");
        System.out.println();

        textInterface.flightControl();
        System.out.println();
        
    }
}
