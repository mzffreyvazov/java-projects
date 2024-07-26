package application;
import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Scanner;

public class GreeterApplication extends Application{


    public static void main(String[] args) {
        launch(args);
    }
    
    @Override 
    public void start(Stage stage) {
        // Create the first view
        
        GridPane firstLayout = new GridPane();
        
        Label text1 = new Label("Enter your name and start.");
        TextField nameField = new TextField();
        Button start = new Button("Start");
        
        firstLayout.add(text1, 0, 0);
        firstLayout.add(nameField, 0, 1);
        firstLayout.add(start, 0, 2);
        
        firstLayout.setPrefSize(300, 150);
        firstLayout.setAlignment(Pos.CENTER);
        firstLayout.setVgap(10);
        firstLayout.setHgap(10);
        firstLayout.setPadding(new Insets(20, 20, 20, 20));
        
        // Create the second view
        BorderPane secondLayout = new BorderPane();
        Label text2 = new Label("");
        
        secondLayout.setPrefSize(300, 180);
        secondLayout.setCenter(text2);
        
        Scene first = new Scene(firstLayout);
        Scene second = new Scene(secondLayout);
        
        start.setOnAction((event) -> {
            String text = nameField.getText();
            text2.setText(String.format("Welcome %s!", text));
            stage.setScene(second);
        });
        
        stage.setScene(first);
        stage.show();
        
    }
}
