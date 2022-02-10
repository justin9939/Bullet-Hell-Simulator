package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game testGame;

    @BeforeEach
    void setUp() {
        testGame = new Game();
    } // setUp

    @Test
    void constructorTest() {
        assertEquals(1, testGame.getUpgrades());
        assertEquals(0, testGame.getFirewalls());
        assertEquals("streamlined", testGame.getWeaponType());
        assertEquals(0, testGame.getBullets().size());
    } // constructorTest

    @Test
    void enemyFireTest() {
        assertEquals(0, testGame.getBullets().size());

        testGame.enemyFire();

        assertEquals(1, testGame.getBullets().size());
        // should I test the properties of bullet in here?

        testGame.enemyFire();
        testGame.enemyFire();

        assertEquals(3, testGame.getBullets().size());

        while(testGame.getBullets().size() < 10) {
            testGame.enemyFire();
        } // while

        assertEquals(10, testGame.getBullets().size());
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
        assertEquals(1, testGame.getUpgrades());

        testGame.collectUpgrade();

        assertEquals(2, testGame.getUpgrades());

        testGame.collectUpgrade();
        testGame.collectUpgrade();

        assertEquals(4, testGame.getUpgrades());

        testGame.collectUpgrade();
        testGame.collectUpgrade();
        testGame.collectUpgrade();
        testGame.collectUpgrade();

        assertEquals(8, testGame.getUpgrades());

        testGame.collectUpgrade();

        assertEquals(8, testGame.getUpgrades());
    } // collectUpgradeTest

    @Test
    void collectFirewallTest() {
        assertEquals(0, testGame.getFirewalls());

        testGame.collectFirewall();

        assertEquals(1, testGame.getFirewalls());

        testGame.collectFirewall();
        testGame.collectFirewall();

        assertEquals(3, testGame.getFirewalls());

        testGame.collectFirewall();

        assertEquals(3, testGame.getFirewalls());
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
        assertEquals(0, testGame.getBullets().size());

        testGame.collectFirewall();
        testGame.collectFirewall();
        testGame.collectFirewall();
        testGame.enemyFire();

        assertEquals(3, testGame.getFirewalls());
        assertEquals(1, testGame.getBullets().size());

        assertTrue(testGame.useFirewall());
        assertEquals(0, testGame.getBullets().size());
        assertEquals(2, testGame.getFirewalls());

        testGame.enemyFire();
        testGame.enemyFire();
        testGame.collectFirewall();
        testGame.collectFirewall();

        assertEquals(0, testGame.getBullets().size());
        assertEquals(3, testGame.getFirewalls());
    } // useFirewallClearBulletsTest

} // GameTest