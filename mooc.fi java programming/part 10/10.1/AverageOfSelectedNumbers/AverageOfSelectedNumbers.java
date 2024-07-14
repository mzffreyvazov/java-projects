
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();
        // toteuta ohjelmasi tänne

        System.out.println("Input numbers, type \"end\" to stop");
        while (true) {
            
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            inputs.add(input);
            
        }
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");

        String second_input = scanner.nextLine();

        if (second_input.equals("n")) {
            double average = inputs.stream()
            .mapToInt(s -> Integer.valueOf(s))
            .filter(s -> s < 0)
            .average()
            .getAsDouble();

            System.out.println("Average of the negative numbers: " + average);
        } else if (second_input.equals("p")) {
            double average = inputs.stream()
            .mapToInt(s -> Integer.valueOf(s))
            .filter(s -> s > 0)
            .average()
            .orElse(0.0);

            System.out.println("Average of the positive numbers: " + average);
        }

    }
}
