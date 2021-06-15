package design.feature.mdm.operator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AssignmentOperatorTest {
    @Test
    void isOperatorTest() {
        assertTrue(AssignmentOperator.O1.isOperator("="));
        assertFalse(ArithmeticOperator.Addition.isOperator("=="));
    }
}
