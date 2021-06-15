package design.feature.mdm.operator;
// here we  define our Comparison Operator . if there is any changes in requirement of Comparison Operator , then we will have to add/remove  here.
public enum ComparisonOperator implements Operator {
    EQUAL("=="), NOTEQUAL("!="), GREATER(">"), LESS("<"), GREATEREQUAL(">="), LESSEQUAL("<=");

    private String operator;

    ComparisonOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean isOperator(String exp) {

        for (ComparisonOperator c : ComparisonOperator.values()) {
            if (c.getOperator().equals(exp)) {
                return true;
            }
        }

        return false;

    }

    @Override
    public void print() {
        for (ComparisonOperator dt : ComparisonOperator.values()) {
            System.out.print(dt.getOperator() + " , ");
        }
        System.out.println("");

    }
}
