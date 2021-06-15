package design.feature.dao;

import design.feature.mdm.DataType;
import java.util.Objects;

public class UserAttribute {

    private final String property;
    private final Object value;

    private UserAttribute(Builder builder) {
        this.property = builder.property;
        this.value = builder.value;
    }

    public String getProperty() {
        return property;
    }

    public Object getValue() {
        return value;
    }

    public static class Builder {
        private String property;
        private Object value;

        public Builder property(String property) {
            this.property = property;
            return this;
        }

        public Builder value(Object value) {
            this.value = value;
            return this;
        }

        public UserAttribute build() {

            Objects.requireNonNull(value);

            DataType.checkType(this.property, value);
            return new UserAttribute(this);
        }

    }

}
