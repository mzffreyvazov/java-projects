package textstatistics;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage window) {
        // Create the BorderPane layout
        BorderPane borderPane = new BorderPane();

        // Create the TextArea for the center
        TextArea textArea = new TextArea();

        // Create Text components for the bottom
        // Create Label components for the bottom
        Label lettersLabel = new Label("Letters: 0");
        Label wordsLabel = new Label("Words: 0");
        Label longestWordLabel = new Label("The longest word is:");

        // Create an HBox for the bottom edge and add Text components to it
        HBox bottomHBox = new HBox(10);
        bottomHBox.getChildren().addAll(lettersLabel, wordsLabel, longestWordLabel);

        // Add the TextArea to the center of the BorderPane
        borderPane.setCenter(textArea);

        // Add the HBox to the bottom of the BorderPane
        borderPane.setBottom(bottomHBox);

        // Create the scene with the BorderPane and specify dimensions
        Scene view = new Scene(borderPane, 400, 300);

        // Set the scene to the stage and show it
        window.setScene(view);
        window.setTitle("TextArea and Bottom Texts Application");
        window.show();
    }

}
