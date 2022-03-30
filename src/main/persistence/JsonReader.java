package persistence;

import model.Game;

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
        this.sourceFile = source;
    } // JsonReader

    // EFFECTS: reads game data from source files and returns it, throwing an IOException
    //          if an error occurs while reading data from the file
    public Game read() throws IOException {
        String jsonData = readFile(sourceFile);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseGame(jsonObject);
    } // read

    // EFFECTS: reads source file as string and returns it, throwing an IOException
    //          if an error occurs while reading data from the file
    // from JsonSerializationDemo.java's JsonReader
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        } // try

        return contentBuilder.toString();
    } // readFile

    // EFFECTS: parses a game state from given JSON object and returns it
    private Game parseGame(JSONObject jsonObject) {
        Game game = new Game();

        loadBulletSpeed(game, jsonObject);
        loadFirewalls(game, jsonObject);
        loadHazards(game, jsonObject);

        return game;
    } // parseGame

    // MODIFIES: game
    // EFFECTS: parses the current bullet speed from given JSON object and
    //          adds it to the given game state
    private void loadBulletSpeed(Game game, JSONObject jsonObject) {
        int speed = jsonObject.getInt("bulletSpeed");
        for (int current = game.getBulletSpeed(); current < speed; current++) {
            game.increaseBulletSpeed();
        } // for
    } // loadBulletSpeed

    // MODIFIES: game
    // EFFECTS: parses the current firewall amount from given JSON object and
    //          adds it to the given game state
    private void loadFirewalls(Game game, JSONObject jsonObject) {
        int firewalls = jsonObject.getInt("firewalls");
        for (int current = game.getFirewalls(); current < firewalls; current++) {
            game.collectFirewall();
        } // for
    } // loadFirewalls

    // MODIFIES: game
    // EFFECTS: parses the current hazards (enemy bullets) from given JSON object and
    //          adds it to the given game state
    private void loadHazards(Game game, JSONObject jsonObject) {
        int hazards = jsonObject.getInt("hazards");
        for (int current = game.getHazards().size(); current < hazards; current++) {
            game.enemyFire();
        } // for
    } // loadHazards
} // JsonReader



