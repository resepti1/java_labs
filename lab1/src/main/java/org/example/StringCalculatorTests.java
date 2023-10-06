package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTests {

    @Test
    public void testEmptyString() throws IncorrectInputException, NegativeInputException {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("");
        assertEquals(0, result);
    }
    @Test
    public void testOneNumber() throws IncorrectInputException, NegativeInputException {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("1");
        assertEquals(1, result);
    }
    @Test
    public void testTwoNumbers() throws IncorrectInputException, NegativeInputException {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("1,2");
        assertEquals(3, result);
    }
    @Test
    public void TestNewLineDelimiter() throws IncorrectInputException, NegativeInputException {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("1\n2,3");
        assertEquals(6, result);
    }

    @Test
    public void IncorrectInputExceptionIsThrown() {
        StringCalculator obj = new StringCalculator();
        assertThrows(IncorrectInputException.class, () -> obj.add("1,\n"));
    }
    @Test
    public void TestOneDelimiter() throws IncorrectInputException, NegativeInputException {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("//[;]\n1;2,4\n5");
        assertEquals(12, result);
    }

    @Test
    public void TestNegativeInput() throws IncorrectInputException, NegativeInputException {
        StringCalculator obj = new StringCalculator();
        assertThrows(NegativeInputException.class, () -> obj.add("-7,2,-6\n"));
    }

    @Test
    public void TestIgnoreThousand() throws IncorrectInputException, NegativeInputException {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("1000,200,1001");
        assertEquals(1200, result);
    }

    @Test
    public void TestBigDelimiter() throws IncorrectInputException, NegativeInputException {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("//[***]\n1***2***3");
        assertEquals(6, result);
    }

    @Test
    public void TestMultiplyDelimiter() throws IncorrectInputException, NegativeInputException {
        StringCalculator obj = new StringCalculator();
        int result = obj.add("//[*][.]\n1.2*2");
        assertEquals(5, result);
    }

}