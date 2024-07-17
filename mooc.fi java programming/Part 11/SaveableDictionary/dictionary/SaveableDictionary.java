package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SaveableDictionary {
    private HashMap<String, String> dictionary;
    private HashMap<String, String> reverseDictionary;
    private String filename;

    
    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
        this.reverseDictionary = new HashMap<>();
        this.filename = null;
    }

    public SaveableDictionary(String file) {
        this(); // Call the existing constructor to initialize dictionaries
        this.filename = file;
    }

    public void add(String words, String translation) {
        if (!(this.dictionary.containsKey(words)) && !this.reverseDictionary.containsKey(translation)) {
            this.dictionary.put(words, translation);
            this.reverseDictionary.put(translation, words);
        }
    }

    public String translate(String word) {
        if (this.dictionary.containsKey(word)) {
            return this.dictionary.get(word);
        } else if (this.reverseDictionary.containsKey(word)) {
            return this.reverseDictionary.get(word);
        } else {
            return null;
        }
    }

    public void delete(String word) {
        if (this.dictionary.containsKey(word)) {
            String translation = this.dictionary.get(word);
            this.dictionary.remove(word);
            this.reverseDictionary.remove(translation);
        } else if (this.reverseDictionary.containsKey(word)) {
            String originalWord = this.reverseDictionary.get(word);
            this.reverseDictionary.remove(word);
            this.dictionary.remove(originalWord);
        }
    }
    

        // New load method
    public boolean load() {
        if (this.filename == null) {
            System.out.println("Error: Filename not specified.");
            return false;
        }

        try {
            File file = new File(this.filename);
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");

                if (parts.length == 2) {
                    String word = parts[0].trim();
                    String translation = parts[1].trim();
                    this.dictionary.put(word, translation);
                    this.reverseDictionary.put(translation, word);
                }
            }

            fileReader.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            return false;
        } catch (Exception e) {
            System.out.println("Error: Unable to read file.");
            return false;
        }
    }

    public boolean save() {
        if (this.filename == null) {
            System.out.println("Error: Filename not specified.");
            return false;
        }

        try {
            FileWriter writer = new FileWriter(this.filename);

            for (Map.Entry<String, String> entry : this.dictionary.entrySet()) {
                String word = entry.getKey();
                String translation = entry.getValue();
                writer.write(word + ":" + translation + "\n");
            }

            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error: Unable to save dictionary to file.");
            return false;
        }
    }
    
}
