package hexlet.code;
import java.util.function.Predicate;
public class NumberSchema extends BaseSchema {
    public void addCheck(String name, Predicate<Object> validate) {
        check.put(name, validate);
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
            if (value instanceof Integer) {
                return (int) value > 0;
            }
            return false;
        });
        return this;
    }
    public NumberSchema range(int firstNumber, int secondNumber) {
        addCheck("range", value -> {
            return ((int) value >= firstNumber) & ((int) value <= secondNumber);
        });
        return this;
    }
}
