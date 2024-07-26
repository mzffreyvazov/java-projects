package title;
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

public class UserTitle extends Application {
    
    @Override
    public void start(Stage window) {
        Parameters params = getParameters();
        String course = params.getNamed().get("course");

        window.setTitle(course);
        window.show();
    }

}
