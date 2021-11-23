package ua.com.foxminded.division.math;

import ua.com.foxminded.division.model.*;

import java.util.ArrayList;
import java.util.List;

public class Divider {
    private Integer dividend;
    private Integer divisor;
    private List<IntermediateValues> changeableValues;
    private Result result;
    private StringBuilder inprogressQuotient;

    public Divider() {
        this.result = new Result();
        this.changeableValues = new ArrayList<>();
        this.inprogressQuotient = new StringBuilder();
    }
    public Result divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException();
        }
        this.dividend = dividend;
        this.divisor = divisor;
        result.setDividend(dividend);
        result.setDivider(divisor);
        result.setResult(dividend / divisor);
        result.setChangeableValues(separatedividendValuesToDivide());
        return result;
    }
    private List<IntermediateValues> separatedividendValuesToDivide() {
        String dividendString = String.valueOf(dividend);
        if (dividendString.contains("-")) {
            char[] dividendToArray = String.valueOf(dividend).toCharArray();
            for (int i = 1; i < dividendToArray.length; i++) {
                inprogressQuotient.append(dividendToArray[i]);
                int quotient = Integer.parseInt(inprogressQuotient.toString());
                divideBySteps(quotient, i, dividendToArray.length);
            }
            return changeableValues;
        } else {
            char[] dividendToArray = String.valueOf(dividend).toCharArray();
            for (int i = 0; i < dividendToArray.length; i++) {
                inprogressQuotient.append(dividendToArray[i]);
                int quotient = Integer.parseInt(inprogressQuotient.toString());
                divideBySteps(quotient, i, dividendToArray.length);
            }
            return changeableValues;
        }
    }
    private void divideBySteps(int changeableQuotient, int inPosition, int dividendLength) {
        if (changeableQuotient >= divisor) {
            IntermediateValues values = buildValues(changeableQuotient, inPosition);
            changeableValues.add(values);
            refreshingChangebleValues(inprogressQuotient, values);
        } else if ((changeableQuotient < divisor) && (inPosition == dividendLength - 1)) {
            changeableValues.add(buildValues(changeableQuotient, inPosition));
        }
    }
    private IntermediateValues buildValues(int changeableQuotient, int inPosition) {
        int smallestQuotient = changeableQuotient / divisor * divisor;
        int shiftToTheRight = inPosition + 1;
        return new IntermediateValues(changeableQuotient, smallestQuotient, shiftToTheRight);
    }
    private void refreshingChangebleValues(StringBuilder inprogressQuotient, IntermediateValues makeDivision) {
        String refreshValue = String.valueOf(makeDivision.getRemainder());
        inprogressQuotient.replace(0, inprogressQuotient.length(), refreshValue);
    }
}
