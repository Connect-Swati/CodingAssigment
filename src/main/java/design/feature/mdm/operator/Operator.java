package design.feature.mdm.operator;

import design.feature.dao.Print;

public interface Operator extends Print {

    boolean isOperator(String exp);

}
