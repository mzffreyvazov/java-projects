package buttonandtextfield;
import javafx.application.Application;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;


public class ButtonAndTextFieldApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }
    
    @Override 
    public void start(Stage stage) {
        Button button = new Button("Click me!");
        TextField text = new TextField("This is a text field");
        
        FlowPane components = new FlowPane();
        components.getChildren().add(button);
        components.getChildren().add(text);
        
        Scene scene = new Scene(components);
        
        stage.setScene(scene);
        stage.show();
        
        
        
        
    }

}
