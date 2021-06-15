package design.feature.mdm.operator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class LogicalOperatorTest {
    @Test
    void isOperatorTest() {
        assertTrue(LogicalOperator.AND.isOperator("&&"));
        assertFalse(LogicalOperator.AND.isOperator("+"));
    }
}
