package assig1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestsTask1 {

    @Test
    public void testFebNoLeap() {
        assertEquals(28, Calendar.calculateDaysInMonth(2, 2023));
        assertEquals(28, Calendar.calculateDaysInMonth(2, 1700));
    }
    ;
    //february - leap year
    @Test
    public void testFebLeap() {
        assertEquals(29, Calendar.calculateDaysInMonth(2, 2024));
        assertEquals(29, Calendar.calculateDaysInMonth(2,2000));
        assertEquals(29, Calendar.calculateDaysInMonth(2, 0));
    }

    @Test
    public void testEquals30() {
        assertEquals(30, Calendar.calculateDaysInMonth(4, 2024));
        assertEquals(30, Calendar.calculateDaysInMonth(6, 2024));
        assertEquals(30, Calendar.calculateDaysInMonth(9, 2024));
        assertEquals(30, Calendar.calculateDaysInMonth(11, 2024));
    }

    @Test
    public void testEquals31() {
        assertEquals(31, Calendar.calculateDaysInMonth(1, 2024));
        assertEquals(31, Calendar.calculateDaysInMonth(3, 2024));
        assertEquals(31, Calendar.calculateDaysInMonth(5, 2024));
        assertEquals(31, Calendar.calculateDaysInMonth(7, 2024));
        assertEquals(31, Calendar.calculateDaysInMonth(8, 2024));
        assertEquals(31, Calendar.calculateDaysInMonth(10, 2024));
        assertEquals(31, Calendar.calculateDaysInMonth(12, 2024));
    }

    @Test
    public void testNotEquals31() {
        assertNotEquals(30, Calendar.calculateDaysInMonth(1, 2024));
    }

    @Test
    public void testNotEquals30() {
        assertNotEquals(31, Calendar.calculateDaysInMonth(9, 2024));
        assertNotEquals(31, Calendar.calculateDaysInMonth(11, 2024));
    }

    @Test
    public void invalidInputs() {
        assertEquals(-1, Calendar.calculateDaysInMonth(2, -1));
        assertEquals(-1, Calendar.calculateDaysInMonth(-1, 2000));
        assertEquals(-1, Calendar.calculateDaysInMonth(13, 2000));
    }

}