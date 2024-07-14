import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LiteracyComparison {

    public static void main(String[] args) {
        try {
            // Read all lines from the file, skip the header line
            List<String> lines = Files.lines(Paths.get("literacy.csv"))
                                      .collect(Collectors.toList());

            // Parse each line and create a list of formatted strings
            List<String> formattedLines = lines.stream()
                    .map(line -> line.split(","))
                    .map(parts -> {
                        String country = parts[3].trim();
                        String year = parts[4].trim();
                        String gender = parts[2].trim().split(" ")[0].trim();
                        double literacyRate = Double.parseDouble(parts[5].trim());
                        return String.format("%s (%s), %s, %.5f", country, year, gender, literacyRate);
                    })
                    .sorted(Comparator.comparingDouble(line -> {
                        // Extract and parse literacy rate for sorting
                        String[] parts = line.split(",");
                        return Double.parseDouble(parts[2].trim().split(" ")[0]);
                    }))
                    .collect(Collectors.toList());

            // Print the sorted formatted lines
            formattedLines.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
