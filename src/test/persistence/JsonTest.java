package persistence;

import model.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkWeaponType(String type, Game game) {
        assertEquals(type, game.getWeaponType());
    } // checkWeaponType

    protected void checkUpgradeLevel(int level, Game game) {
        assertEquals(level, game.getUpgradeLevel());
    } // checkUpgradeLevel

    protected void checkFirewallAmount(int amount, Game game) {
        assertEquals(amount, game.getFirewalls());
    } // checkFirewallAmount

    protected void checkHazards(int amount, Game game) {
        assertEquals(amount, game.getHazards().size());
    } // checkHazards
} // JsonTest