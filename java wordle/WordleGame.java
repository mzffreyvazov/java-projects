import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class WordleGame extends JFrame {
    private static final int WORD_LENGTH = 6;
    private static final int MAX_ATTEMPTS = WORD_LENGTH + 1;
    private List<String> wordList;
    private Random random = new Random();

    private JTextField[] guessFields;
    private JButton submitButton;
    private JButton shareButton;
    private JLabel feedbackLabel;
    private String targetWord;
    private int currentAttempt;
    private List<boolean[]> guessResults = new ArrayList<>();

    public WordleGame() {
        

        setTitle("Wordle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(MAX_ATTEMPTS + 3, 1));
        loadWordsFromFile();

        EnterKeyListener enterKeyListener = new EnterKeyListener();
        guessFields = new JTextField[MAX_ATTEMPTS];
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            guessFields[i] = new JTextField(WORD_LENGTH);
            guessFields[i].setHorizontalAlignment(JTextField.CENTER);
            guessFields[i].setFont(new Font("Arial", Font.BOLD, 20));
            guessFields[i].addKeyListener(enterKeyListener);  // Add this line
            add(guessFields[i]);
        }

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        add(submitButton);

        feedbackLabel = new JLabel("Enter your guess");
        feedbackLabel.setHorizontalAlignment(JLabel.CENTER);
        add(feedbackLabel);

        shareButton = new JButton("Share");
        shareButton.setEnabled(false);
        shareButton.addActionListener(e -> shareResult());
        add(shareButton);

        targetWord = getRandomWord();
        currentAttempt = 0;

        pack();
        setLocationRelativeTo(null);
    }

    private void loadWordsFromFile() {
        wordList = new ArrayList<>();
        String fileName = WORD_LENGTH + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() == WORD_LENGTH) {
                    wordList.add(line.toUpperCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading word list: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        if (wordList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No words found in " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private String getRandomWord() {
        return wordList.get(random.nextInt(wordList.size()));
    }


    private void submitGuess() {
        submitButton.doClick();
    }

    private class EnterKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                submitGuess();
            }
        }
    }

    private void shareResult() {
        BufferedImage image = generateShareImage();
        try {
            File outputfile = new File("wordle_result.png");
            ImageIO.write(image, "png", outputfile);
            JOptionPane.showMessageDialog(this, "Result image saved as wordle_result.png");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving image", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private BufferedImage generateShareImage() {
        int width = WORD_LENGTH * 50;
        int height = guessResults.size() * 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        for (int row = 0; row < guessResults.size(); row++) {
            boolean[] result = guessResults.get(row);
            for (int col = 0; col < WORD_LENGTH; col++) {
                g2d.setColor(result[col] ? Color.GREEN : Color.GRAY);
                g2d.fillRect(col * 50, row * 50, 45, 45);
            }
        }

        g2d.dispose();
        return image;
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {



            if (currentAttempt >= MAX_ATTEMPTS) {
                feedbackLabel.setText("Game over! The word was: " + targetWord);
                return;
            }
    
            String guess = guessFields[currentAttempt].getText().toUpperCase();
            if (guess.length() != WORD_LENGTH) {
                feedbackLabel.setText("Please enter a " + WORD_LENGTH + "-letter word");
                return;
            }
    
            boolean[] correctPositions = new boolean[WORD_LENGTH];
            boolean[] usedTargetLetters = new boolean[WORD_LENGTH];
    
            // First pass: mark correct positions
            for (int i = 0; i < WORD_LENGTH; i++) {
                if (guess.charAt(i) == targetWord.charAt(i)) {
                    correctPositions[i] = true;
                    usedTargetLetters[i] = true;
                }
            }
    
            // Second pass: mark letters in wrong positions
            for (int i = 0; i < WORD_LENGTH; i++) {
                if (!correctPositions[i]) {
                    for (int j = 0; j < WORD_LENGTH; j++) {
                        if (!usedTargetLetters[j] && guess.charAt(i) == targetWord.charAt(j)) {
                            usedTargetLetters[j] = true;
                            break;
                        }
                    }
                }
            }
    
            // Apply colors to the text field
            JTextField currentField = guessFields[currentAttempt];
            currentField.setEditable(false);
            for (int i = 0; i < WORD_LENGTH; i++) {
                if (correctPositions[i]) {
                    highlightLetter(currentField, i, Color.GREEN);
                } else if (targetWord.contains(String.valueOf(guess.charAt(i))) && !correctPositions[i]) {
                    highlightLetter(currentField, i, Color.GRAY);
                }
            }
    
            if (guess.equals(targetWord)) {
                feedbackLabel.setText("Congratulations! You guessed the word!");
                submitButton.setEnabled(false);
                shareButton.setEnabled(true);
            } else {
                currentAttempt++;
                if (currentAttempt < MAX_ATTEMPTS) {
                    guessFields[currentAttempt].requestFocus();  // Make sure this line is here
                } else {
                    feedbackLabel.setText("Game over! The word was: " + targetWord);
                    submitButton.setEnabled(false);
                    shareButton.setEnabled(true);
                }
            }

            boolean[] currentGuessResult = new boolean[WORD_LENGTH];
            for (int i = 0; i < WORD_LENGTH; i++) {
                currentGuessResult[i] = correctPositions[i];
            }
            guessResults.add(currentGuessResult);

            if (guess.equals(targetWord) || currentAttempt >= MAX_ATTEMPTS - 1) {
                shareButton.setEnabled(true);
            }
        }
    
        private void highlightLetter(JTextField field, int position, Color color) {
            try {
                field.getHighlighter().addHighlight(
                    position, position + 1,
                    new DefaultHighlighter.DefaultHighlightPainter(color)
                );
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordleGame().setVisible(true));
    }
}