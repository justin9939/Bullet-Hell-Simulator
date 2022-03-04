package persistence;

import model.Game;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {

    // based on JsonSerializationDemo's JsonReaderTest
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/ligma.json");
        try {
            Game game = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        } // try... catch
    } // testReaderNonExistentFile

    @Test
    void testReaderNewGame() {
        JsonReader reader = new JsonReader("./data/testReaderNewGame.json");
        try {
            Game game = reader.read();
            checkWeaponType("streamlined", game);
            checkUpgradeLevel(1, game);
            checkFirewallAmount(0, game);
            checkHazards(0, game);
        } catch (IOException e) {
            fail("Couldn't read from file");
        } // try... catch
    } // testReaderNewGame

    @Test
    void testReaderPlayedGame() {
        JsonReader reader = new JsonReader("./data/testReaderPlayedGame.json");
        try {
            Game game = reader.read();
            checkWeaponType("spread", game);
            checkUpgradeLevel(6, game);
            checkFirewallAmount(2, game);
            checkHazards(9, game);
        } catch (IOException e) {
            fail("Couldn't read from file");
        } // try... catch
    } // testReaderPlayedGame
} // JsonReaderTest
