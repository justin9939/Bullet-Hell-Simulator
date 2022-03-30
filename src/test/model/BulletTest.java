package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BulletTest {
    Bullet testBullet;
    int upperX = Bullet.UPPER_X;
    int upperY = Bullet.UPPER_Y;

    @BeforeEach
    void setUp() {
        testBullet = new Bullet(0, 0);
    } // setUp

    @Test
    void constructorTest() {
        assertEquals(0, testBullet.getPositionX());
        assertEquals(0, testBullet.getPositionY());
        assertEquals(1, testBullet.getMoveX());
        assertEquals(1, testBullet.getMoveY());
    } // constructorTest

    @Test
    void setSpeedTest() {
        assertEquals(1, testBullet.getMoveX());
        assertEquals(1, testBullet.getMoveY());

        testBullet.setSpeed(3);
        assertEquals(3, testBullet.getMoveX());
        assertEquals(3, testBullet.getMoveY());
    } // speedUpTest

    @Test
    void moveTestNoBounce() {
        assertEquals(0, testBullet.getPositionX());
        assertEquals(0, testBullet.getPositionY());

        testBullet.move();
        assertEquals(1, testBullet.getPositionX());
        assertEquals(1, testBullet.getPositionY());

        testBullet.move();
        assertEquals(2, testBullet.getPositionX());
        assertEquals(2, testBullet.getPositionY());
    } // moveTestNoBounce

    @Test
    void moveTestAlmostBounceX() {
        Bullet testBulletAlmostBounceX = new Bullet(upperX - 2, 100);

        assertEquals(upperX - 2, testBulletAlmostBounceX.getPositionX());
        assertEquals(100, testBulletAlmostBounceX.getPositionY());
        assertEquals(1, testBulletAlmostBounceX.getMoveX());
        assertEquals(1, testBulletAlmostBounceX.getMoveY());

        testBulletAlmostBounceX.move();
        assertEquals(upperX - 1, testBulletAlmostBounceX.getPositionX());
        assertEquals(101, testBulletAlmostBounceX.getPositionY());
        assertEquals(1, testBulletAlmostBounceX.getMoveX());
        assertEquals(1, testBulletAlmostBounceX.getMoveY());
    } // moveTestAlmostBounceX

    @Test
    void moveTestAlmostBounceY() {
        Bullet testBulletAlmostBounceY = new Bullet(100, upperY - 2);

        assertEquals(100, testBulletAlmostBounceY.getPositionX());
        assertEquals(upperY - 2, testBulletAlmostBounceY.getPositionY());
        assertEquals(1, testBulletAlmostBounceY.getMoveX());
        assertEquals(1, testBulletAlmostBounceY.getMoveY());

        testBulletAlmostBounceY.move();
        assertEquals(101, testBulletAlmostBounceY.getPositionX());
        assertEquals(upperY - 1, testBulletAlmostBounceY.getPositionY());
        assertEquals(1, testBulletAlmostBounceY.getMoveX());
        assertEquals(1, testBulletAlmostBounceY.getMoveY());
    } // moveTestAlmostBounceY

    @Test
    void moveTestBounceX() {
        Bullet testBulletBounceX = new Bullet(upperX - 1, 0);

        assertEquals(upperX - 1, testBulletBounceX.getPositionX());
        assertEquals(0, testBulletBounceX.getPositionY());
        assertEquals(1, testBulletBounceX.getMoveX());
        assertEquals(1, testBulletBounceX.getMoveY());

        testBulletBounceX.move();
        assertEquals(upperX, testBulletBounceX.getPositionX());
        assertEquals(1, testBulletBounceX.getPositionY());
        assertEquals(1, testBulletBounceX.getMoveX());
        assertEquals(1, testBulletBounceX.getMoveY());

        testBulletBounceX.move();
        assertEquals(upperX - 1, testBulletBounceX.getPositionX());
        assertEquals(2, testBulletBounceX.getPositionY());
        assertEquals(-1, testBulletBounceX.getMoveX());
        assertEquals(1, testBulletBounceX.getMoveY());
    } // moveTestBounceX

    @Test
    void moveTestBounceY() {
        Bullet testBulletBounceY = new Bullet(0, upperY - 1);

        assertEquals(0, testBulletBounceY.getPositionX());
        assertEquals(upperY - 1, testBulletBounceY.getPositionY());
        assertEquals(1, testBulletBounceY.getMoveX());
        assertEquals(1, testBulletBounceY.getMoveY());

        testBulletBounceY.move();
        assertEquals(1, testBulletBounceY.getPositionX());
        assertEquals(upperY, testBulletBounceY.getPositionY());
        assertEquals(1, testBulletBounceY.getMoveX());
        assertEquals(1, testBulletBounceY.getMoveY());

        testBulletBounceY.move();
        assertEquals(2, testBulletBounceY.getPositionX());
        assertEquals(upperY - 1, testBulletBounceY.getPositionY());
        assertEquals(1, testBulletBounceY.getMoveX());
        assertEquals(-1, testBulletBounceY.getMoveY());
    } // moveTestBounceY

} // BulletTest
