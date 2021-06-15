package design.feature;

import design.feature.dao.UserAttribute;
import design.feature.mdm.AttributeTableSingleton;
import design.feature.mdm.DataType;
import design.feature.mdm.operator.ArithmeticOperator;
import design.feature.mdm.operator.AssignmentOperator;
import design.feature.mdm.operator.ComparisonOperator;
import design.feature.mdm.operator.LogicalOperator;
import design.feature.util.EvaluateExpression;
import java.util.HashMap;
import java.util.Map;
import javax.script.ScriptException;

public class StartProgram {

    public static void main(String[] args) throws ScriptException {
        StartProgram sp = new StartProgram();
        AttributeTableSingleton attributeTable = sp.createUserAttributeTable();

        // ---------------------------------------------------
        Map<String, Object> userAttributes = sp.takenUserInput();

        // ------------------------------------------------------

        sp.printMasterData(attributeTable);


        String feature1 = "feature : Can have multiple entries";
        String f_expression1 ="( ( age > 25 && gender == 'male' ) || past_order_amount > 10000 )";

        String privilage1 = " privilage : Have  Privilage of car parking at main area";
        String p_expression1 = "( ( salary > 250 || city == 'BLR' ) && gender == 'female' )";

        // tested format for "expression syntax"  supported vs not supported
        //"( ( salary > 250 || city == 'BLR' ) && gender == 'female' )"; -- work
        //"( salary > 250)"; -- > work
        // "80 > ( 25 + 3 )"; --> work
        // "( age > 50 )"; --> work
        // "( ( age > ( 25 + 3 ) ) && gender == 'male' )" --> work

        // "( ( age > 70 ) )"; --> not work
        //"( salary > 250 || city == 'BLR' )"; --> not work

        EvaluateExpression.validateExpDataType(f_expression1, userAttributes);
        boolean result1 = EvaluateExpression.isAllowed(feature1, f_expression1, userAttributes);
        System.out.println("Is user allowed for " + feature1 + "?" + "\nanswer is " + result1);
        System.out.println("-----------------------------------");

        EvaluateExpression.validateExpDataType(p_expression1, userAttributes);
        boolean result3 = EvaluateExpression.isAllowed(privilage1, p_expression1, userAttributes);
        System.out.println("Is user allowed for " + privilage1 + "?" + "\nanswer is " + result3);


    }

    AttributeTableSingleton createUserAttributeTable() {
        AttributeTableSingleton attributeTable = AttributeTableSingleton.INSTANCE;

        attributeTable.addAttribute("gender", DataType.STRING);
        attributeTable.addAttribute("age", DataType.NUMBER);
        attributeTable.addAttribute("salary", DataType.NUMBER);
        attributeTable.addAttribute("height", DataType.NUMBER);
        attributeTable.addAttribute("past_order_amount", DataType.NUMBER);
        attributeTable.addAttribute("is_affluent", DataType.BOOLEAN);
        attributeTable.addAttribute("city", DataType.STRING);
        attributeTable.addAttribute("spends", DataType.NUMBER);
        attributeTable.addAttribute("latitude", DataType.NUMBER);
        attributeTable.addAttribute("longitude", DataType.NUMBER);

        return attributeTable;
    }

    Map<String, Object> takenUserInput() {
        // here we provide value for below attributes . on basis of these value our expression is calculated

        Map<String, Object> userAttributes = new HashMap<>();
        UserAttribute.Builder builder = new UserAttribute.Builder();
        UserAttribute ua = builder.property("age").value(26).build();
        userAttributes.put(ua.getProperty(), ua.getValue());

        ua = builder.property("gender").value("male").build();
        userAttributes.put(ua.getProperty(), ua.getValue());

        ua = builder.property("past_order_amount").value(9000).build();
        userAttributes.put(ua.getProperty(), ua.getValue());

        ua = builder.property("salary").value(900).build();
        userAttributes.put(ua.getProperty(), ua.getValue());

        ua = builder.property("height").value(5).build();
        userAttributes.put(ua.getProperty(), ua.getValue());

        ua = builder.property("is_affluent").value(true).build();
        userAttributes.put(ua.getProperty(), ua.getValue());

        ua = builder.property("city").value("BLR").build();
        userAttributes.put(ua.getProperty(), ua.getValue());

        ua = builder.property("spends").value(1000).build();
        userAttributes.put(ua.getProperty(), ua.getValue());

        ua = builder.property("latitude").value(14).build();
        userAttributes.put(ua.getProperty(), ua.getValue());

        ua = builder.property("longitude").value(10).build();
        userAttributes.put(ua.getProperty(), ua.getValue());
        return userAttributes;
    }

    private void printMasterData(AttributeTableSingleton attributeTable) {
        attributeTable.print();
        DataType.NUMBER.print();
        System.out.println("Operator supported are : ");
        System.out.println("-----------------------------------");
        System.out.println("ArithmeticOperators supported are : ");
        ArithmeticOperator.Decrement.print();
        System.out.println("AssignmentOperator supported are : ");
        AssignmentOperator.O1.print();
        System.out.println("ComparisonOperator supported are : ");
        ComparisonOperator.EQUAL.print();
        System.out.println("LogicalOperator supported are : ");
        LogicalOperator.AND.print();
        System.out.println("");

    }

}
