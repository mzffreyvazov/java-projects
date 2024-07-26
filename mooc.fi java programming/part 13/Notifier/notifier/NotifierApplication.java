package notifier;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class NotifierApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage window) {
        // Create the BorderPane layout

        TextField textArea = new TextField();
        textArea.setPrefHeight(30);
        textArea.setPrefWidth(200);
        
        Button update = new Button("Update");
        update.setPrefHeight(30);
        update.setPrefWidth(100);
        
        Label bottomText = new Label("");
        
        update.setOnAction((event) -> {
            bottomText.setText(textArea.getText());
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        
        
        vbox.getChildren().addAll(textArea, update, bottomText);
        


        // Create the scene with the BorderPane and specify dimensions
        Scene view = new Scene(vbox, 300, 200);

        // Set the scene to the stage and show it
        window.setScene(view);
        window.setTitle("Notifier");
        window.show();
    }


}
