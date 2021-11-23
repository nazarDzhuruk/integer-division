package ua.com.foxminded.division;

import org.junit.jupiter.api.Test;
import ua.com.foxminded.division.math.*;
import ua.com.foxminded.division.model.*;

import static org.junit.jupiter.api.Assertions.*;

public class DividerTest {
    private Divider divider;
    private Result result;
    private Integer actual;

    @Test
    public void divideExampleNumbers(){
        int expected = 19736;
        makeDivision(78945, 4);
        assertEquals(expected, actual);
    }
    @Test
    public void zeroDivisorTest() throws ArithmeticException{
        assertThrows(ArithmeticException.class, () -> {
            Divider divider = new Divider();
            divider.divide(122,0);
        });
    }
    @Test
    public void zeroDividendTest(){
        int expected = 0;
        makeDivision(0, 123);
        assertEquals(expected, actual);
    }
    @Test
    public void divideTwoNegativeValues(){
        int expected = 61;
        makeDivision(-122, -2);
        assertEquals(expected, actual);
    }
    @Test
    public void bigDivisorTest(){
        int expected = 0;
        makeDivision(123, 1234);
        assertEquals(expected, actual);
    }
    @Test
    public void divideByOne(){
        int expected = 123456;
        makeDivision(123456, 1);
        assertEquals(expected, actual);
    }
    @Test
    public void remainderTest(){
        int expected = 1033;
        makeDivision(630440, 610);
        assertEquals(expected, actual);
    }
    @Test
    public void carryOverZeros(){
        int expected = 10008;
        makeDivision(12350000, 1234);
        assertEquals(expected, actual);
    }
    @Test
    public void oneMoreTest(){
        int expected = 10000;
        makeDivision(12340035, 1234);
        assertEquals(expected, actual);
    }
    public void makeDivision(int dividend, int divisor){
        divider = new Divider();
        result = divider.divide(dividend, divisor);
        actual = result.getResult();
    }
}
