package design.feature.util;

import design.feature.mdm.operator.ArithmeticOperator;
import design.feature.mdm.operator.ComparisonOperator;
import design.feature.mdm.operator.LogicalOperator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EvaluateExpression {
    private EvaluateExpression() {
    }

    public static boolean isAllowed(String featureName, String conditionalExpression,
        Map<String, Object> userAttributes) throws ScriptException {

        Set<String> keys = userAttributes.keySet();
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        for (String key : keys) {
            engine.put(key, userAttributes.get(key));
        }

        return (boolean) engine.eval(conditionalExpression);
    }

    public static void validateExpDataType(String expression, Map<String, Object> userAttributes) {
        String[] expArray = expression.split(" ");

        Stack<Object> stack = new Stack<Object>();
        Boolean check = false;
        for (String exp : expArray) {
            if (exp.equals("(") || ComparisonOperator.EQUAL.isOperator(exp)
                            || LogicalOperator.AND.isOperator(exp)
                            || ArithmeticOperator.Addition.isOperator(exp)) {

                stack.push(exp);
            } else if (exp.equals(")")) {
                Object bracketExp = "";
                while (!bracketExp.equals("(") && !stack.isEmpty()) {

                    Object rhs = !stack.empty() ? stack.pop() : "NA";
                    Object operator = !stack.empty() ? stack.pop() : "NA";
                    Object lhs = !stack.empty() ? stack.pop() : "NA";

                    if (!stack.empty()) {
                        bracketExp = stack.pop();// pop "("
                    }
                    if ("NA".equals(rhs) || "NA".equals(lhs)) {
                        throw new IllegalArgumentException("NA");

                    }
                    if ((rhs instanceof String && lhs instanceof String)) {

                        if (!stack.isEmpty()) {
                            String randomString = "random";
                            stack.push(randomString);
                        }
                        check = true;
                    } else if (rhs instanceof Integer && lhs instanceof Integer) {

                        if (!stack.isEmpty()) {
                            int randomIn = 0;
                            stack.push(randomIn);
                        }
                        check = true;
                    } else {
                        check = false;

                        throw new IllegalArgumentException(
                                "In expression "+ expression+ "   Data type on both LHS and RHS of Operator are not same. Provide Expression in supported format");
                    }

                    if (stack.isEmpty()) {
                        break;
                    }

                }

            } else {

                if (ValidationUtil.isVariable(exp)) {
                    exp = "" + userAttributes.get(exp);
                }
                Boolean digitCheck = ValidationUtil.onlyDigits(exp);
                Boolean stringCheck = ValidationUtil.isAlphaNumeric(exp);

                if (digitCheck) {
                    int number = Integer.parseInt(exp);
                    stack.push(number);
                } else if (stringCheck) {

                    stack.push(exp);

                }
            }

        }
        System.out.println( "In expression  "+ expression + "  Data type on both LHS and RHS of Operator are same" );

    }

}
