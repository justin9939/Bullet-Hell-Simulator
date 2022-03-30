package persistence;

import model.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkBulletSpeed(int speed, Game game) {
        assertEquals(speed, game.getBulletSpeed());
    } // checkUpgradeLevel

    protected void checkFirewallAmount(int amount, Game game) {
        assertEquals(amount, game.getFirewalls());
    } // checkFirewallAmount

    protected void checkHazards(int amount, Game game) {
        assertEquals(amount, game.getHazards().size());
    } // checkHazards
} // JsonTest