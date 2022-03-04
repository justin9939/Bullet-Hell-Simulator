package persistence;

import model.Game;
import model.Bullet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that can load game progress by reading JSON data stored in a file
// based on JsonReader from JsonSerializationDemo.java
public class JsonReader {
    private String sourceFile;

    // EFFECTS: constructs a reader to read from given source file
    public JsonReader(String source) {
        // stub
    }

    // EFFECTS: reads game data from source files and returns it, throwing an IOException
    //          if an error occurs while reading data from the file
    public Game read() throws IOException {
        return null; // stub
    }

    // EFFECTS: reads source file as string and returns it, throwing an IOException
    //          if an error occurs while reading data from the file
    // from JsonSerializationDemo.java's JsonReader
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses a game state from given JSON object and returns it
    private Game parseGame(JSONObject jsonObject) {
        return null; // stub
    }

    // MODIFIES: game
    // EFFECTS: parses all savable aspects of a game state from given JSON object and adds it to
    //          the given game state
    private void loadAllGameStates() {
        // stub
    }

    // MODIFIES: game
    // EFFECTS: parses a single savable aspect of a game state from given JSON object and adds it to
    //          the given game state
    private void loadGameState() {
        // stub
    }

}
