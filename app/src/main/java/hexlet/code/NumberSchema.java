package hexlet.code;

import java.util.Map;
import java.util.function.Predicate;



public class NumberSchema extends BaseSchema {


    @Override
    public StringSchema minLength(int minLength) {
        return null;
    }

    @Override
    public StringSchema contains(String contains) {
        return null;
    }
    public NumberSchema required() {

        addCheck("required", value -> {
            if ((value instanceof Integer) & (value != null) & (check.containsKey("required"))) {
                return true;
            } else {
                return value instanceof Integer;
            }
        });
        return this;
    }
    public NumberSchema positive() {
        addCheck("positive", value -> {
            return (int) value > 0;
        });
        return this;
    }
    public NumberSchema range(int firstNumber, int secondNumber) {
        addCheck("range", value -> {
            return ((int) value >= firstNumber) & ((int) value <= secondNumber);
        });
        return this;
    }
    public Boolean isValid(Object object) {
        if ((object == null) & (!check.containsKey("required"))) {
            return true;
        } else if ((object == null) & (check.containsKey("required"))) {
            return false;

        } else if (!(object instanceof Integer)) {
            return false;
        } else if ((check.containsKey("required") & (!check.containsKey("positive")
                & (!check.containsKey("range"))))) {
            return false;
        }

        Boolean[] array;

        for (Map.Entry<String, Predicate<Object>> result : check.entrySet()) {

            Predicate<Object> value = result.getValue();
            Boolean bool = value.test(object);
            array = new Boolean[]{bool};
            for (int i = 0; i < array.length; i++) {
                if (!array[i]) {
                    return false;
                }

            }
        }
        return true;
    }

}
