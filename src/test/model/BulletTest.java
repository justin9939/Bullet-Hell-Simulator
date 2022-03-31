package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BulletTest {
    Bullet testBullet;

    @BeforeEach
    void setUp() {
        testBullet = new Bullet(0, 0, 1);
    } // setUp

    @Test
    void constructorTest() {
        assertEquals(0, testBullet.getPositionX());
        assertEquals(0, testBullet.getPositionY());
        assertEquals(1, testBullet.getDamage());
    } // constructorTest
} // BulletTest
