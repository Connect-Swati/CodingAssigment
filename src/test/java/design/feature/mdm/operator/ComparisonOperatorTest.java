package design.feature.mdm.operator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ComparisonOperatorTest {

    @Test
    void isOperatorTest() {
        assertTrue(ComparisonOperator.EQUAL.isOperator(">"));
        assertFalse(ComparisonOperator.EQUAL.isOperator("+"));
    }
}
