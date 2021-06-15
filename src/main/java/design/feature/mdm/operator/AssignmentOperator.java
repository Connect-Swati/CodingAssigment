package design.feature.mdm.operator;
// here we  define our Assignment  operator . if there is any changes in requirement of Assignment operator , then we will have to add/remove  here.
public enum AssignmentOperator implements Operator {
    O1("="), O2("+="), O3("-="), O4("*="), O5("/="), O6("%="), O7("&="), O8("|="), O9("^="),
    O10(">>="), O11("<<=");

    private String operator;

    AssignmentOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean isOperator(String exp) {

        for (AssignmentOperator c : AssignmentOperator.values()) {
            if (c.getOperator().equals(exp)) {
                return true;
            }
        }

        return false;

    }

    @Override
    public void print() {
        for (AssignmentOperator dt : AssignmentOperator.values()) {
            System.out.print(dt.getOperator() + " , ");
        }
        System.out.println("");

    }
}
