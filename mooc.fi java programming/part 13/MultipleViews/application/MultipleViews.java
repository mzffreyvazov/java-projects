package application;
import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        // Set the first scene's components
        BorderPane firstLayout = new BorderPane();
        Label firstSceneText = new Label("First view!");
        Button firstSceneButton = new Button("To the second view!"); 
        
        firstLayout.setTop(firstSceneText);
        firstLayout.setCenter(firstSceneButton);
        
        // Set the second scene's components
        VBox secondLayout = new VBox(10);
        secondLayout.setSpacing(10);
        
        Label secondSceneText = new Label("Second view!");
        Button secondSceneButton = new Button("To the third view!");
        
        secondLayout.getChildren().addAll(secondSceneButton, secondSceneText);
        
        // Set the third scene's components
        GridPane thirdLayout = new GridPane();
        Label thirdSceneText = new Label("Third view!");
        Button thirdSceneButton = new Button("To the first view!");
        
        thirdLayout.add(thirdSceneText, 0, 0);
        thirdLayout.add(thirdSceneButton, 1, 1);
        
        
        
        // Create the scenes
        Scene first = new Scene(firstLayout, 300, 250);
        Scene second = new Scene(secondLayout, 300, 250);
        Scene third = new Scene(thirdLayout, 300, 250);
        
        // Set the events for the buttons
        firstSceneButton.setOnAction((event)-> {
            stage.setScene(second);
        });
        
        secondSceneButton.setOnAction((event)-> {
            stage.setScene(third);
        });
        
        thirdSceneButton.setOnAction((event)-> {
            stage.setScene(first);
        });        
        
        // Start the scene
        stage.setScene(first);
        stage.show();
    }

}
