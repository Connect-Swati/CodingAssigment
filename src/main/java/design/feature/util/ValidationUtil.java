package design.feature.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
// it is used by EvaluateExpression() to identify
// //that a string in expression contains only digits or only alphabet. on the basis of its result, rhs and lhs validation is done.

public class ValidationUtil {
    private ValidationUtil() {

    }

    public static boolean onlyDigits(String str) {

        if (str == null) {
            return false;
        }

        String regex = "[0-9]+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean isAlphaNumeric(String str) {
        if (str.matches("[0-9]+")) {
            return false;
        }
        return ((str != null) && (!str.equals("")) && (str.matches(".*[a-zA-Z]*$")));
    }

    public static boolean isVariable(String str) {
        if (onlyDigits(str)) {
            return false;
        }

        return !(null == str || str.startsWith("'") || str.startsWith("\""));
    }

}
