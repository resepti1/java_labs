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

    @Test
    public void testNewLine1() {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("1\n4,2");
        assertEquals(7, result);
    }

    @Test
    public void testNewLine2() {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("4,2\n5");
        assertEquals(11, result);
    }

    @Test
    public void testCustomDelimiter1() {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("//;\n1;2");
        assertEquals(3, result);
    }

    @Test
    public void testCustomDelimiter2() {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("//.1.2\n5");
        assertEquals(8, result);
    }
}