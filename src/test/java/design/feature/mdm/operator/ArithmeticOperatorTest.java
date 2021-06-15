package design.feature.mdm.operator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ArithmeticOperatorTest {
    @Test
    void isOperatorTest() {
        assertTrue(ArithmeticOperator.Addition.isOperator("+"));
        assertFalse(ArithmeticOperator.Addition.isOperator("=="));
    }
}
