package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {
    public void addCheck(String name, Predicate<Object> validate) {
        check.put(name, validate);
    }
    static int stringLength;
    static String count;

    // проверка на пустоту
    public StringSchema required() {
        addCheck("required", value -> {
            if (value instanceof String && !((String) value).isEmpty()) {
                return true;
            } else if (!(value instanceof String)) {
                return false;
            }
            return true;
        });
        return this;
    }

    // ограничение минимальной длины
    public StringSchema minLength(int min) {
        stringLength = min;
        addCheck("minLength", value -> value.toString().length() >= min);
        return this;
    }

    // ограничение содержимого строки
    public StringSchema contains(String substring) {
        count = substring;
        addCheck("contains", value -> ((String) value).contains(substring));
        return this;
    }
}
