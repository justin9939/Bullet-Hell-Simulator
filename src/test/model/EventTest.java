package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the Event class
 */
// from AlarmSystem's EventTest
public class EventTest {
    private Event e;
    private Date d;

    // NOTE: these tests might fail if time at which line (2) below is executed
    //       is different from time that line (1) is executed.  Lines (1) and (2) must
    //       run in same millisecond for this test to make sense and pass.

    @BeforeEach
    public void runBefore() {
        e = new Event("Bullet fired");   // (1)
        d = Calendar.getInstance().getTime();   // (2)
    } // runBefore

    @Test
    public void testEvent() {
        assertEquals("Bullet fired", e.getDescription());
        assertEquals(d, e.getDate());
    } // testEvent

    @Test
    public void testToString() {
        assertEquals(d.toString() + "\n" + "Bullet fired", e.toString());
    } // testToString
} // EventTest
