package buttonandlabel;

import javafx.application.Application;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ButtonAndLabelApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button button  = new Button("Click me");
        Label textLabel = new Label("Text will show here");
        
        FlowPane components = new FlowPane();
        components.getChildren().add(button);
        components.getChildren().add(textLabel);
        
        Scene view = new Scene(components);
        
        stage.setScene(view); // Set the scene on the stage
        stage.show(); // Show the stage
    }
}
