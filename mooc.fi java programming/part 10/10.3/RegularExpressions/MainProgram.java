import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String weekday = scanner.nextLine();

        Checker checker = new Checker();

        if (checker.isDayOfWeek(weekday)) {
            System.out.println("The form is correct.");
        } else {
            System.out.println("The form is incorrect.");
        }

        scanner.close();

    }
}
