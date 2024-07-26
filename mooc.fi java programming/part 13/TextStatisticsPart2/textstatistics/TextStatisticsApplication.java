package textstatistics;
import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage window) {
        // Create the BorderPane layout
        BorderPane layout = new BorderPane();
        
        TextArea text = new TextArea();
        
        Label lettersLabel = new Label("Letters: 0");
        Label wordsLabel = new Label("Words: 0");
        Label longestWordLabel = new Label("The longest word is:");

        HBox bottomHBox = new HBox(10);
        bottomHBox.getChildren().addAll(lettersLabel, wordsLabel, longestWordLabel);
        
        layout.setCenter(text);

        // Add the HBox to the bottom of the BorderPane
        layout.setBottom(bottomHBox);

        text.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();

            // set values of text elements
            
            lettersLabel.setText("Letters: " + characters);
            wordsLabel.setText("Words: " + words);
            longestWordLabel.setText(String.format("The longest word is: %s", longest));
            
            
        });

        // Create the scene with the BorderPane and specify dimensions
        Scene view = new Scene(layout, 300, 200);

        // Set the scene to the stage and show it
        window.setScene(view);
        window.setTitle("Notifier");
        window.show();
    }

}
