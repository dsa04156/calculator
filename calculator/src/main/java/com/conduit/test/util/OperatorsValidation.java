package com.conduit.test.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperatorsValidation {
    public static boolean checkOperatorsValidation(String[] operators) {
        if (operators.length == 3 && checkOperation(operators[1]) && checkNumbers(operators[0], operators[2])) {
            return true;
        } else {
            System.out.println("잘못된 숫자를 입력하셨습니다.");
            return false;
        }

    }

    private static boolean checkNumbers(String num1, String num2) {
        String pattern = "[0-9]+(\\.[0-9]*)?";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(num1);
        Matcher m2 = p.matcher(num2);
        return m.matches() && m2.matches();
    }


    private static boolean checkOperation(String operation) {
        return operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/");
    }
}
