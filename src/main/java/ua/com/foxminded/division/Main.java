package ua.com.foxminded.division;

import ua.com.foxminded.division.math.*;
import ua.com.foxminded.division.model.Result;
import ua.com.foxminded.division.text.*;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.print("Wrong input!");
            String message = "Try input two separately values";
        throw new NumberFormatException(message);
        }
        int dividend = Integer.parseInt(args[0]);
        int divisor = Integer.parseInt(args[1]);

        Divider divider = new Divider();
        Result result = divider.divide(dividend, divisor);

        Formatter formatter = new Formatter();
        List<String> output = formatter.format(result);
        for (String divisionSteps : output) {
            System.out.println(divisionSteps);
        }
    }
}