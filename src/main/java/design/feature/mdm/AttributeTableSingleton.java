package design.feature.mdm;

import design.feature.dao.Print;
import java.util.HashMap;
import java.util.Map;

public enum AttributeTableSingleton implements Print {
    INSTANCE;

    private final Map<String, DataType> userAttributes = new HashMap<>();

    public void addAttribute(String property, DataType dataType) {
        userAttributes.put(property, dataType);
    }

    public DataType getDataType(String property) {
        return userAttributes.get(property);
    }

    public Map<String, DataType> getAttributes() {
        return userAttributes;
    }

    @Override
    public void print() {
        System.out.println("List of the supported user attributes ");
        System.out.println("-----------------------------------");
        System.out.println(this.userAttributes);
        System.out.println("");


    }
}
