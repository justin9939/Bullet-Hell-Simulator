package persistence;

import model.Game;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    // based on JsonSerializationDemo's JsonWriterTest
    @Test
    void testWriterInvalidFile() {
        try {
            Game game = new Game();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        } // try... catch
    } // testWriterInvalidFile

    @Test
    void testWriterNewGame() {
        try {
            Game game = new Game();
            JsonWriter writer = new JsonWriter("./data/testWriterNewGame.json");
            writer.open();
            writer.write(game);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterNewGame.json");
            game = reader.read();
            checkBulletSpeed(1, game);
            checkFirewallAmount(0, game);
            checkHazards(0, game);
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        } // try... catch
    } // testWriterNewGame

    @Test
    void testWriterPlayedGame() {
        try {
            Game game = new Game();
            for (int i = 1; i < 8; i++) {
                game.increaseBulletSpeed(); // 8
                game.enemyFire(); // 7
            } // for

            game.collectFirewall();

            JsonWriter writer = new JsonWriter("./data/testWriterPlayedGame.json");
            writer.open();
            writer.write(game);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterPlayedGame.json");
            game = reader.read();
            checkBulletSpeed(8, game);
            checkFirewallAmount(1, game);
            checkHazards(7, game);
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        } // try... catch
    } // testWriterPlayedGame
} // JsonWriterTest

