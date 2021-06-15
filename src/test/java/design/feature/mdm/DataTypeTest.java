package design.feature.mdm;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class DataTypeTest {

    @Test
    void checkTypeTest() {
        AttributeTableSingleton.INSTANCE.addAttribute("age", DataType.NUMBER);
        AttributeTableSingleton.INSTANCE.addAttribute("gender", DataType.STRING);

        assertTrue(DataType.checkType("age", 20));
        assertThrows(IllegalArgumentException.class, () -> DataType.checkType("age", true));

    }

    @Test
    void printTest() {
        DataType.NUMBER.print();
    }
}