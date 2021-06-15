package design.feature.mdm.operator;
// here we  define our Logical Operator . if there is any changes in requirement of Logical Operator , then we will have to add/remove  here.

public enum LogicalOperator implements Operator {
    AND("&&"), OR("||"), NOT("!");

    private String operator;

    LogicalOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean isOperator(String exp) {

        for (LogicalOperator c : LogicalOperator.values()) {
            if (c.getOperator().equals(exp)) {
                return true;
            }
        }

        return false;

    }

    @Override
    public void print() {
        for (LogicalOperator dt : LogicalOperator.values()) {
            System.out.print(dt.getOperator() + " , ");
        }
        System.out.println("");

    }
}
