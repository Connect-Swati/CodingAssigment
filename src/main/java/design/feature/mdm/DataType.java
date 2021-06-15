package design.feature.mdm;

import design.feature.dao.Print;
import java.util.Objects;

public enum DataType implements Print {
    NUMBER(Number.class), STRING(String.class), BOOLEAN(Boolean.class);

    private final Class<?> clazz;

    DataType(Class<?> clazz) {
        this.clazz = clazz;
    }

    public static boolean checkType(String property, Object object) {

        DataType dataType = AttributeTableSingleton.INSTANCE.getDataType(property);
        Objects.requireNonNull(dataType);

        if (dataType.clazz.isAssignableFrom(object.getClass())) {
            return true;
        }

        throw new IllegalArgumentException(
            "Invalid Data Type. Expected " + dataType.clazz.getSimpleName() + " but Found "
                            + object.getClass().getSimpleName());

    }

    @Override
    public void print() {
        System.out.println("List the supported data types");
        System.out.println("-----------------------------------------");
        for (DataType dt : DataType.values()) {
            System.out.print(dt.name() + " , ");
        }
        System.out.println("");

    }
}