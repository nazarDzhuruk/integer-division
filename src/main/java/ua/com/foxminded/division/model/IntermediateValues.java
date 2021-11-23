package ua.com.foxminded.division.model;

public class IntermediateValues {
    private Integer changeableQuotient;
    private Integer shiftToTheRight;
    private Integer remainder;
    private Integer smallestQuotient;

    public IntermediateValues(Integer changeableQuotient, Integer smallestQuotient, Integer shiftToTheRight) {
        this.changeableQuotient = changeableQuotient;
        this.smallestQuotient = smallestQuotient;
        this.shiftToTheRight = shiftToTheRight;
        this.remainder = changeableQuotient - smallestQuotient;
    }
    public Integer getChangeableQuotient() {
        return changeableQuotient;
    }
    public Integer getShiftToTheRight() {
        return shiftToTheRight;
    }
    public Integer getRemainder() {
        return remainder;
    }
    public Integer getSmallestQuotient() {
        return smallestQuotient;
    }
}
