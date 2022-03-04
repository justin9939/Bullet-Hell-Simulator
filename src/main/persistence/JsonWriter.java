package persistence;

import model.Game;
import org.json.JSONObject;

import java.io.*;

// Represents a writer that writes a JSON representation of a game state to a file
// based on JsonWriter from JsonSerializationDemo.java
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destinationFile;

    // EFFECTS: constructs a writer to write to given destination file
    public JsonWriter(String destination) {
        this.destinationFile = destination;
    } // JsonWriter

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    // from JsonSerializationDemo's JsonWriter.java
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destinationFile));
    } // open

    // MODIFIES: this
    // EFFECTS: writes a JSON representation of game to file
    public void write(Game game) {
        JSONObject json = game.toJson();
        saveToFile(json.toString(TAB));
    } // write

    // MODIFIES: this
    // EFFECTS: closes writer
    // from JsonSerializationDemo's JsonWriter.java
    public void close() {
        writer.close();
    } // close

    // MODIFIES: this
    // EFFECTS: writes string to file
    // from JsonSerializationDemo's JsonWriter.java
    private void saveToFile(String json) {
        writer.print(json);
    } // saveToFile
} // JsonWriter
