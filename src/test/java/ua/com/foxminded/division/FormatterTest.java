package ua.com.foxminded.division;

import org.junit.jupiter.api.Test;
import ua.com.foxminded.division.math.*;
import ua.com.foxminded.division.model.Result;
import ua.com.foxminded.division.text.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatterTest {
    private Divider divider;
    private Formatter draw;
    private Result result;
    private List<String> actual;

    @Test
    public void drawZero() {
        List<String> expected = Arrays.asList("_0|122",
                " 0|-",
                " -|0",
                " 0");
        makeDivisionAndDraw(0, 122);
        assertEquals(expected, actual);
    }
    @Test
    public void exampleIntegerDivisionTest() {
        List<String> expected = Arrays.asList("_78945|4",
                " 4    |-----",
                " -    |19736",
                " 38",
                " 36",
                " --",
                "  29",
                "  28",
                "  --",
                "   14",
                "   12",
                "   --",
                "    25",
                "    24",
                "    --",
                "     1");
        makeDivisionAndDraw(78945, 4);
        assertEquals(expected, actual);
    }
    @Test
    public void divideTwoNegativeValues() {
        List<String> expected = Arrays.asList("_-78945|-4",
                "  4      |-----",
                "  -      |19736",
                "  38",
                "  36",
                "  --",
                "   29",
                "   28",
                "   --",
                "    14",
                "    12",
                "    --",
                "     25",
                "     24",
                "     --",
                "      1");
        makeDivisionAndDraw(-78945, -4);
        assertEquals(expected, actual);
    }
    @Test
    public void drawDivisionByOne() {
        List<String> expected = Arrays.asList("_1234321|1",
                " 1      |-------",
                " -      |1234321",
                "  2",
                "  2",
                "  -",
                "   3",
                "   3",
                "   -",
                "    4",
                "    4",
                "    -",
                "     3",
                "     3",
                "     -",
                "      2",
                "      2",
                "      -",
                "       1",
                "       1",
                "       -",
                "       0");
        makeDivisionAndDraw(1234321, 1);
        assertEquals(expected, actual);
    }
    @Test
    public void drawRemainder() {
        List<String> expected = Arrays.asList("_12|234",
                "  0|-",
                " --|0",
                " 12");
        makeDivisionAndDraw(12, 234);
        assertEquals(expected, actual);
    }
    @Test
    public void carryOverZeros() {
        List<String> expected = Arrays.asList("_12350000|1234",
                " 1234    |-----",
                " ----    |10008",
                "    10000",
                "     9872",
                "    -----",
                "      128");
        makeDivisionAndDraw(12350000, 1234);
        assertEquals(expected, actual);
    }
    public void makeDivisionAndDraw(int dividend, int divisor) {
        divider = new Divider();
        result = divider.divide(dividend, divisor);
        draw = new Formatter();
        actual = draw.format(result);
    }
}
