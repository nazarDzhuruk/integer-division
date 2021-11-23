package ua.com.foxminded.division.model;

import java.util.List;

public class Result {
    private Integer divider;
    private Integer dividend;
    private Integer result;
    private List<IntermediateValues> changeableValues;

    public Integer getDivider() {
        return divider;
    }
    public void setDivider(Integer divider) {
        this.divider = divider;
    }
    public Integer getDividend() {
        return dividend;
    }
    public void setDividend(Integer dividend) {
        this.dividend = dividend;
    }
    public Integer getResult() {
        return result;
    }
    public void setResult(Integer result) {
        this.result = result;
    }
    public List<IntermediateValues> getChangeableValues() {
        return changeableValues;
    }
    public void setChangeableValues(List<IntermediateValues> changeableValues) {
        this.changeableValues = changeableValues;
    }
}
