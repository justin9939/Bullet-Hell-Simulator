package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game testGame;
    int maxFirewalls = Game.MAX_FIREWALLS;
    int maxBulletSpeed = Game.MAX_BULLET_SPEED;

    @BeforeEach
    void setUp() {
        testGame = new Game();
    } // setUp

    @Test
    void constructorTest() {
        assertEquals(1, testGame.getBulletSpeed());
        assertEquals(0, testGame.getFirewalls());
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
    void increaseBulletSpeedTest() {
        assertEquals(1, testGame.getBulletSpeed());

        testGame.increaseBulletSpeed();

        assertEquals(2, testGame.getBulletSpeed());

        testGame.increaseBulletSpeed();
        testGame.increaseBulletSpeed();

        assertEquals(4, testGame.getBulletSpeed());

        testGame.increaseBulletSpeed();
        testGame.increaseBulletSpeed();
        testGame.increaseBulletSpeed();
        testGame.increaseBulletSpeed();

        assertEquals(maxBulletSpeed, testGame.getBulletSpeed());

        testGame.increaseBulletSpeed();

        assertEquals(maxBulletSpeed, testGame.getBulletSpeed());
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
        testGame.increaseBulletSpeed();
        testGame.collectFirewall();
        testGame.enemyFire();

        assertEquals(2, testGame.getBulletSpeed());
        assertEquals(1, testGame.getFirewalls());
        assertEquals(1, testGame.getHazards().size());

        testGame.newGame();

        assertEquals(1, testGame.getBulletSpeed());
        assertEquals(0, testGame.getFirewalls());
        assertEquals(0, testGame.getHazards().size());
    } // newGameTest

} // GameTest