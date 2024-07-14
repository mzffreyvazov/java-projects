import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                break;
            }

            System.out.print("Input the age recommendation: ");
            int ageRecommendation = Integer.parseInt(scanner.nextLine());

            books.add(new Book(name, ageRecommendation));
            System.out.println();
        }

        System.out.println();
        System.out.println(books.size() + " books in total.");
        System.out.println();
        System.out.println("Books:");

        Collections.sort(books);

        for (Book book : books) {
            System.out.println(book);
        }

        scanner.close();
    }
}