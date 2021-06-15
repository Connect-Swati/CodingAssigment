package design.feature.mdm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AttributeTableSingletonTest {

    @Test
    void getDataTypePostiveCaseTest() {
        AttributeTableSingleton.INSTANCE.addAttribute("age", DataType.NUMBER);
        AttributeTableSingleton.INSTANCE.addAttribute("gender", DataType.STRING);

        assertEquals(DataType.NUMBER, AttributeTableSingleton.INSTANCE.getDataType("age"));

    }

    @Test
    void printTest() {
        AttributeTableSingleton.INSTANCE.print();
    }
}