package FlightControl.ui;
import java.util.Scanner;

import FlightControl.logic.FlightControl;

public class TextInterface {
    private Scanner scanner;
    private FlightControl control;


    public TextInterface() {
        this.scanner = new Scanner(System.in);
        this.control = new FlightControl();
    }

    public void assetControl() {
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
    
            System.out.print("> "); 

            String action = scanner.nextLine();

            if (action.equals("x")) {
                break;
            } else if (action.equals("1")) {

                // Ask the user for airplane ID and capacity
                System.out.print("Give the airplane id: ");
                String id = scanner.nextLine();

                System.out.print("\nGive the airplane capacity: ");
                int capacity = Integer.parseInt(scanner.nextLine());

                // Add the airplane
                control.addAirplane(id, capacity);

            } else {

                // Ask the user for airplane ID, departure ID and destination ID

                // Check if the airplane id is valid
                String id;
                while (true) {
                    System.out.print("Give the airplane id: ");
                    id = scanner.nextLine();
                    
                    if (control.checkAirplane(id)) {
                        break;  // Valid ID, exit the loop
                    } else {
                        System.out.print("Invalid airplane ID. Please try again.");
                    }
                }
                System.out.print("Give the departure airport id: ");
                String departurId = scanner.nextLine();

                System.out.print("Give the target airport id: ");
                String destinationId = scanner.nextLine();

                // Add the flight
                control.addFlight(id, departurId, destinationId);
            }
        }
    }

    public void flightControl() {

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
    
            System.out.print("> "); 

            String action = scanner.nextLine();  
            
            if (action.equals("1")) {
                // Print Airplanes
                control.printAirplanes();

            } else if (action.equals("2")) {
                // Print Flights
                control.printFlights(); 
            } else if (action.equals("3")) {
                // Print Airplane Details
                System.out.print("Give the airplane ID: ");
                String ID = scanner.nextLine();
                System.out.println(control.printAirplaneDetails(ID));
            } else if (action.equals("x")) {
                break;
            }

        }

        scanner.close();
    }
}
