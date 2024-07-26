package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Scanner;

public class JokeApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }
    
    @Override 
    public void start(Stage stage) {
        // Main layout 
        BorderPane layout = new BorderPane();
        
         // 1.1. Create menu for main layout
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        
        // 1.2. Create buttons for menu
        Button first = new Button("Joke");
        Button second = new Button("Answer");
        Button third = new Button("Explanation");

        // 1.3. Add buttons to menu
        menu.getChildren().addAll(first, second, third);

        layout.setTop(menu);     
        
        // Subviews
        StackPane firstlayout = createView("What do you call a bear with no teeth?");
        StackPane secondlayout = createView("A gummy bear.");
        StackPane thirdlayout = createView("Here's the explanation for the joke");
        
        
        // Buttan event handlers
        first.setOnAction((event) -> {
            layout.setCenter(firstlayout);
        });

        second.setOnAction((event) -> {
            layout.setCenter(secondlayout);
        });
        
        third.setOnAction((event) -> {
            layout.setCenter(thirdlayout);
        });        
        
        layout.setCenter(firstlayout);
        Scene scene = new Scene(layout);


        // 4. Show the main scene
        stage.setScene(scene);
        stage.show();
    }
    
    private StackPane createView(String text) {

        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
}
