package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTests {

    @Test
    public void testEmptyString() throws NegativeInputException, IncorrectInputException, DelimiterInputException {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("");
        assertEquals(0, result);
    }
    @Test
    public void testOneNumber() throws NegativeInputException, IncorrectInputException, DelimiterInputException {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("1");
        assertEquals(1, result);
    }
    @Test
    public void testTwoNumbers() throws NegativeInputException, IncorrectInputException, DelimiterInputException {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("1,2");
        assertEquals(3, result);
    }

    @Test
    public void testNewLine1() throws NegativeInputException, IncorrectInputException, DelimiterInputException {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("1\n4,2");
        assertEquals(7, result);
    }

    @Test
    public void testNewLine2() throws NegativeInputException, IncorrectInputException, DelimiterInputException {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("4,2\n5");
        assertEquals(11, result);
    }

    @Test
    public void OneCharDelimiter() throws NegativeInputException, IncorrectInputException, DelimiterInputException {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("//[;]\n1;2");
        assertEquals(3, result);
    }

    @Test
    public void IncorrectInputExceptionIsThrown() {
        StringCalculator obj = new StringCalculator();
        assertThrows(IncorrectInputException.class, () -> obj.add("1,\n"));
    }

    @Test
    public void NegativeInputExceptionIsThrown() {
        StringCalculator obj = new StringCalculator();
        assertThrows(NegativeInputException.class, () -> obj.add("-7,2"));
    }

    @Test
    public void DelimiterInputExceptionIsThrown() {
        StringCalculator obj = new StringCalculator();
        assertThrows(DelimiterInputException.class, () -> obj.add("//.1.2.3"));
    }

    @Test
    public void NumberGreater1000() throws NegativeInputException, IncorrectInputException, DelimiterInputException {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("1000,1");
        assertEquals(1999, result);
    }

    @Test
    public void AnyLengthDelimiter() throws NegativeInputException, IncorrectInputException, DelimiterInputException {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("//[***]\n10***20***1");
        assertEquals(31, result);
    }

}