package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeapYearTest {

    @Test
    public void isLeapYear_yearNonDivisibleBy4_false() {
        boolean actual = LeapYear.isLeapYear(1);
        Assertions.assertFalse(actual);
    }

    @Test
    public void isLeapYear_yearDivisibleBy4_true() {
        boolean actual = LeapYear.isLeapYear(4);
        Assertions.assertTrue(actual);
    }

    @Test
    public void isLeapYear_yearDivisibleBy100_false() {
        boolean actual = LeapYear.isLeapYear(100);
        Assertions.assertFalse(actual);
    }

    @Test
    public void isLeapYear_yearDivisibleBy400_true() {
        boolean actual = LeapYear.isLeapYear(400);
        Assertions.assertTrue(actual);
    }
}
