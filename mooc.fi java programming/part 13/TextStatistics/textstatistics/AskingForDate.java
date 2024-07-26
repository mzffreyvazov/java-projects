/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textstatistics;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.Random;

/**
 *
 * @author muzaf
 */
public class AskingForDate extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        yesButton.setPrefSize(100, 50);
        noButton.setPrefSize(100, 50);
        
        Label text = new Label("Would you go on a date with me?");
        
        BorderPane.setAlignment(text, javafx.geometry.Pos.CENTER);
        
        double paneWidth = 400; // Width of the Pane
        double paneHeight = 300; // Height of the Pane
        double buttonSpacing = 20; // Space between buttons
        double totalWidth = yesButton.getPrefWidth() + yesButton.getPrefWidth() + buttonSpacing;

        // Position the buttons horizontally centered in the Pane
        yesButton.setLayoutX((paneWidth - totalWidth) / 2);
        yesButton.setLayoutY((paneHeight - yesButton.getPrefHeight()) / 2);

        noButton.setLayoutX(yesButton.getLayoutX() + yesButton.getPrefWidth() + buttonSpacing);
        noButton.setLayoutY(yesButton.getLayoutY());

        // Add buttons to the Pane
        layout.getChildren().addAll(yesButton, noButton);     
        Scene view = new Scene(layout, 400, 300);

        // Set the scene to the stage and show it
        stage.setScene(view);
        stage.setTitle("TextArea and Bottom Labels Application");
        stage.show();

    }
}
