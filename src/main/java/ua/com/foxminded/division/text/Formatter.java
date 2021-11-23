package ua.com.foxminded.division.text;

import ua.com.foxminded.division.model.*;

import java.util.ArrayList;
import java.util.List;

public class Formatter {
    private String underline = "_";
    private String vLine = "|";
    private String dash = "-";
    private String space = " ";

    public List<String> format(Result result) {
        List<String> makeView = new ArrayList<>();
        finalizeConstructor(makeView, result);
        dividendView(makeView, result);
        dividerView(makeView, result);
        divisionResult(makeView, result);
        return makeView;
    }
    private void builder(List<String> makeView, IntermediateValues values) {
        subtractionStepFirstView(makeView, values);
        subtractionStepSecondView(makeView, values);
        overChangeableQuotientView(makeView, values);
    }
    private void finalizeConstructor(List<String> makeView, Result result) {
        for (int i = 0; i < result.getChangeableValues().size(); i++) {
            builder(makeView, result.getChangeableValues().get(i));
        }
        lastSubtractionDigitView(makeView, result);
    }
    private void subtractionStepFirstView(List<String> makeView, IntermediateValues values) {
        String subtractionUpResult = String.valueOf(values.getChangeableQuotient());
        int position = values.getShiftToTheRight() - subtractionUpResult.length();

        String formatQuotient = adjustableString(space, position) + space + subtractionUpResult;
        makeView.add(formatQuotient);
    }
    private void subtractionStepSecondView(List<String> makeView, IntermediateValues values) {
        String subtractionBottomResult = String.valueOf(values.getSmallestQuotient());
        int position = values.getShiftToTheRight() - subtractionBottomResult.length();

        String subtractionBottomResultFormat = adjustableString(space, position) + space + subtractionBottomResult;
        makeView.add(subtractionBottomResultFormat);
    }
    private void overChangeableQuotientView(List<String> makeView, IntermediateValues values) {
        String subtractionUpResult = String.valueOf(values.getChangeableQuotient());
        int position = values.getShiftToTheRight() - subtractionUpResult.length();

        String overQuotientFormat = adjustableString(space, position) + space + adjustableString(dash, subtractionUpResult.length());
        makeView.add(overQuotientFormat);
    }
    private void lastSubtractionDigitView(List<String> makeView, Result result) {
        IntermediateValues values = result.getChangeableValues().get(result.getChangeableValues().size() - 1);
        String formatRemainder = String.valueOf(values.getRemainder());
        int position = values.getShiftToTheRight() - formatRemainder.length();

        String formatLastSubtraction = adjustableString(space, position) + space + formatRemainder;
        makeView.add(formatLastSubtraction);
    }
    private void dividendView(List<String> makeView, Result result) {
        String formatdividend = underline + result.getDividend();
        makeView.set(0, formatdividend);
    }
    private void dividerView(List<String> makeView, Result result) {
        String format = makeView.get(0);
        String dividerFormat = format + vLine + result.getDivider();

        makeView.set(0, dividerFormat);
    }
    private void resultDashes(List<String> makeView, Result result) {
        String resultDashes = makeView.get(1);
        int resultIntegerLength = resultLength(result.getResult());
        String addDashes = adjustableString(dash, resultIntegerLength);
        int position = countInnerSpaces(makeView, result.getDivider());

        String underDividerLineFormat = resultDashes + adjustableString(space, position) + vLine + addDashes;
        makeView.set(1, underDividerLineFormat);
    }
    private void divisionResult(List<String> makeView, Result result) {
        resultDashes(makeView, result);
        resultView(makeView, result);
    }
    private void resultView(List<String> makeView, Result result) {
        String resultFormat = makeView.get(2);
        int position = countInnerSpaces(makeView, result.getDivider());
        String answer = String.valueOf(result.getResult());

        String answerFormat = resultFormat + adjustableString(space, position) + vLine + answer;
        makeView.set(2, answerFormat);
    }
    private int countInnerSpaces(List<String> result, int divider) {
        int firstRowLength = result.get(0).length();
        int thirdRowLength = result.get(2).length();
        int dividerLength = resultLength(divider);

        int thirdRowInnerSpacesCount = firstRowLength - thirdRowLength - vLine.length() - dividerLength;
        return thirdRowInnerSpacesCount;
    }
    private String adjustableString(String format, int number) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            builder.append(format);
        }
        return builder.toString();
    }
    private int resultLength(int number) {
        if (number == 0) {
            return 1;
        } else {
            return (int) (Math.log10(number) + 1);
        }
    }
}
