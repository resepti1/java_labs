package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTests {

    @Test
    public void testEmptyString() {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("");
        assertEquals(0, result);
    }
    @Test
    public void testOneNumber() {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("1");
        assertEquals(1, result);
    }
    @Test
    public void testTwoNumbers() {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("1,2");
        assertEquals(3, result);
    }
    @Test
    public void testNegativeAddPositive() {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("-7,2");
        assertEquals(-5, result);
    }


}