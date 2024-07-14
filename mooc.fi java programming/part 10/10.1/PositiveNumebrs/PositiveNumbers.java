
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(7);
        list.add(4);
        list.add(2);
        list.add(6);
        list.add(-34);

        System.out.println(positive(list));

    }

    public static List<Integer> positive(List<Integer> numbers) {
        List<Integer> last = numbers.stream()
        .filter(s -> s > 0)
        .collect(Collectors.toList());

        return last;
    }

}
