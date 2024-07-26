package borderpane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        BorderPane components = new BorderPane();
        
        // Create Text components
        Label northText = new Label("NORTH");
        Label eastText = new Label("EAST");
        Label southText = new Label("SOUTH");

        // Add Text components to the BorderPane
        components.setTop(northText);
        components.setRight(eastText);
        components.setBottom(southText);
        
        
        Scene view = new Scene(components);
        
        stage.setScene(view); // Set the scene on the stage
        stage.show(); // Show the stage
    }

}
