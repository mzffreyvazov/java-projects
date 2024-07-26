import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class TicTacToeApplication extends Application {
    private static final int COLS = 3, ROWS = 3;
    private String currentPlayer = "X";
    private Label toptext;
    private Button[][] board = new Button[ROWS][COLS];
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override 
    public void start(Stage stage) {
        // Main layout
        BorderPane mainlayout = new BorderPane();
        
        toptext = new Label("Turn: X");
        toptext.setFont(new Font(20));
        
        // Create the buttons
        GridPane gridlayout = new GridPane();
        gridlayout.setPadding(new Insets(10, 10, 10, 10));
        gridlayout.setVgap(10);
        gridlayout.setHgap(10);
        
        for (int x = 0; x < ROWS; x++) {
            for (int y = 0; y < COLS; y++) {
                Button button = createButton();
                button.setOnAction(e -> handleButtonClick(button));
                gridlayout.add(button, y, x);
                board[x][y] = button;
            }
        }
        
        
        mainlayout.setTop(toptext);
        mainlayout.setCenter(gridlayout);
        
        Scene view = new Scene(mainlayout);

        // 7. Show the application
        stage.setScene(view);
        stage.show();
        
        
    }
    
    private void handleButtonClick(Button button) {
        if (button.getText().isEmpty()) {
            button.setText(currentPlayer);
            
            if (checkForWin(currentPlayer)) {
                toptext.setText("The end!");
                disableAllButtons();
            } else if (checkForDraw()) {
                toptext.setText("The end!");
                disableAllButtons();
            } else {
                currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                toptext.setText("Turn: " + currentPlayer);
            }
        }
    }
    
    private Button createButton() {
        Button button = new Button();
        button.setFont(Font.font("Monospaced", 40));
        button.setPrefSize(100, 100);
        button.setMinSize(100, 100);
        button.setMaxSize(100, 100);
        return button;
    }
    
    private boolean checkForWin(String player) {
        // Check rows
        for (int row = 0; row < ROWS; row++) {
            if (board[row][0].getText().equals(player) &&
                board[row][1].getText().equals(player) &&
                board[row][2].getText().equals(player)) {
                return true;
            }
        }
        
        // Check columns
        for (int col = 0; col < COLS; col++) {
            if (board[0][col].getText().equals(player) &&
                board[1][col].getText().equals(player) &&
                board[2][col].getText().equals(player)) {
                return true;
            }
        }
        
        // Check diagonals
        if (board[0][0].getText().equals(player) &&
            board[1][1].getText().equals(player) &&
            board[2][2].getText().equals(player)) {
            return true;
        }
        
        if (board[0][2].getText().equals(player) &&
            board[1][1].getText().equals(player) &&
            board[2][0].getText().equals(player)) {
            return true;
        }
        
        return false;
    }
    
    private boolean checkForDraw() {
        for (Button[] row : board) {
            for (Button button : row) {
                if (button.getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void disableAllButtons() {
        for (Button[] row : board) {
            for (Button button : row) {
                button.setDisable(true);
            }
        }
    }

}
