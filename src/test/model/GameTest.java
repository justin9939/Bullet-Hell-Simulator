package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game testGame;
    int maxFirewalls = Game.MAX_FIREWALLS;
    int maxUpgradeLevel = Game.MAX_UPGRADE_LEVEL;

    @BeforeEach
    void setUp() {
        testGame = new Game();
    } // setUp

    @Test
    void constructorTest() {
        assertEquals(1, testGame.getUpgradeLevel());
        assertEquals(0, testGame.getFirewalls());
        assertEquals("streamlined", testGame.getWeaponType());
        assertEquals(0, testGame.getHazards().size());
    } // constructorTest

    @Test
    void enemyFireTest() {
        assertEquals(0, testGame.getHazards().size());

        testGame.enemyFire();

        assertEquals(1, testGame.getHazards().size());
        // should I test the properties of bullet in here?

        testGame.enemyFire();
        testGame.enemyFire();

        assertEquals(3, testGame.getHazards().size());

        while(testGame.getHazards().size() < 10) {
            testGame.enemyFire();
        } // while

        assertEquals(10, testGame.getHazards().size());
    } // enemyFireTest

    @Test
    void changeWeaponTest() {
        assertEquals("streamlined", testGame.getWeaponType());

        testGame.changeWeaponType();
        assertEquals("spread", testGame.getWeaponType());

        testGame.changeWeaponType();
        assertEquals("streamlined", testGame.getWeaponType());
    } // changeWeaponTest

    @Test
    void collectUpgradeTest() {
        assertEquals(1, testGame.getUpgradeLevel());

        testGame.collectUpgrade();

        assertEquals(2, testGame.getUpgradeLevel());

        testGame.collectUpgrade();
        testGame.collectUpgrade();

        assertEquals(4, testGame.getUpgradeLevel());

        testGame.collectUpgrade();
        testGame.collectUpgrade();
        testGame.collectUpgrade();
        testGame.collectUpgrade();

        assertEquals(maxUpgradeLevel, testGame.getUpgradeLevel());

        testGame.collectUpgrade();

        assertEquals(maxUpgradeLevel, testGame.getUpgradeLevel());
    } // collectUpgradeTest

    @Test
    void collectFirewallTest() {
        assertEquals(0, testGame.getFirewalls());

        testGame.collectFirewall();

        assertEquals(1, testGame.getFirewalls());

        testGame.collectFirewall();
        testGame.collectFirewall();

        assertEquals(maxFirewalls, testGame.getFirewalls());

        testGame.collectFirewall();

        assertEquals(maxFirewalls, testGame.getFirewalls());
    } // collectFirewallTest

    @Test
    void useFirewallTest() {
        testGame.collectFirewall();
        testGame.collectFirewall();

        assertEquals(2, testGame.getFirewalls());
        assertTrue(testGame.useFirewall());
        assertEquals(1, testGame.getFirewalls());
        assertTrue(testGame.useFirewall());
        assertEquals(0, testGame.getFirewalls());

        assertFalse(testGame.useFirewall());
    } // useFirewallTest

    @Test
    void useFirewallClearBulletsTest() {
        assertEquals(0, testGame.getFirewalls());
        assertEquals(0, testGame.getHazards().size());

        testGame.collectFirewall();
        testGame.collectFirewall();
        testGame.collectFirewall();
        testGame.enemyFire();

        assertEquals(maxFirewalls, testGame.getFirewalls());
        assertEquals(1, testGame.getHazards().size());

        assertTrue(testGame.useFirewall());
        assertEquals(0, testGame.getHazards().size());
        assertEquals(2, testGame.getFirewalls());

        testGame.enemyFire();
        testGame.enemyFire();
        testGame.collectFirewall();
        testGame.collectFirewall();

        assertEquals(0, testGame.getHazards().size());
        assertEquals(maxFirewalls, testGame.getFirewalls());
    } // useFirewallClearBulletsTest

    @Test
    void newGameTest() {
        testGame.collectUpgrade();
        testGame.collectFirewall();
        testGame.changeWeaponType();
        testGame.enemyFire();

        assertEquals(2, testGame.getUpgradeLevel());
        assertEquals(1, testGame.getFirewalls());
        assertEquals("spread", testGame.getWeaponType());
        assertEquals(1, testGame.getHazards().size());

        testGame.newGame();

        assertEquals(1, testGame.getUpgradeLevel());
        assertEquals(0, testGame.getFirewalls());
        assertEquals("streamlined", testGame.getWeaponType());
        assertEquals(0, testGame.getHazards().size());
    } // newGameTest

} // GameTest