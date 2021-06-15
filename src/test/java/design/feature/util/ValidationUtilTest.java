package design.feature.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ValidationUtilTest {

    @Test
    void isOnlyDigitsPositiveTest() {

        String digit = "1685";
        assertTrue(ValidationUtil.onlyDigits(digit));
    }

    @Test
    void isOnlyDigitsNegativeTest() {

        String digit = "male85";
        assertFalse(ValidationUtil.onlyDigits(digit));
    }

    @Test
    void isStringOnlyAlphabetPositiveCase() {
        String alphabet = "male";
        assertTrue(ValidationUtil.isAlphaNumeric(alphabet));
    }

    @Test // getting failed
    void isStringOnlyAlphabetNegativeCase() {
        String alphabet = "123";
        assertFalse(ValidationUtil.isAlphaNumeric(alphabet));
    }

    @Test
    void isVariable() {
        String alphabet = "age";
        assertTrue(ValidationUtil.isVariable(alphabet));

        alphabet = "123";
        assertFalse(ValidationUtil.isVariable(alphabet));
    }
}