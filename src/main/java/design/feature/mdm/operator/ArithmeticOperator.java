package design.feature.mdm.operator;
// here we  define our arithmetic operator . if there is any changes in requirement of operator , then we will have to add/remove  here.
public enum ArithmeticOperator implements Operator {
    Addition("+"), Subtraction("-"), Multiplication("*"), Division("/"), Modulus("%"),
    Increment("++"), Decrement("--");

    private String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;

    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean isOperator(String exp) {

        for (ArithmeticOperator c : ArithmeticOperator.values()) {
            if (c.getOperator().equals(exp)) {
                return true;
            }
        }

        return false;

    }

    @Override
    public void print() {
        for (ArithmeticOperator dt : ArithmeticOperator.values()) {
            System.out.print(dt.getOperator() + " , ");
        }
        System.out.println("");

    }

}
