package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
//import java.util.Objects;

import java.util.function.Predicate;

public class StringSchema extends BaseClass {
    static Map<String, Predicate<Object>> check = new LinkedHashMap<>();


    static int stringLength;
    static String count;


    // проверка на пустоту
    public StringSchema required() {
        check.put("required", str -> str instanceof String && ((String) str).isEmpty());
        return this;
    }

    // ограничение минимальной длины
    public StringSchema minLength(int min) {
        check.put("minLength", str -> str.toString().length() >= min);
        stringLength = min;
        return this;

    }

    // ограничение содержимого строки
    public StringSchema contains(String string) {
        check.put("contains", str -> str.toString().contains(string));
        count = string;
        return this;
    }

    public Boolean isValid(Object object) {

        if ((!check.containsKey("required")) & ((check.get("minLength")) == null || (check.get("contains") == null))) {
            return true;
        } else if ((check.containsKey("required")) & ((check.get("minLength") == null)
                & (check.get("contains") == null))) {
            return false;


        } else if (check.containsKey("minLength") && (check.containsKey("contains"))) {
            return check.get("minLength").test(object) && check.get("contains").test(object);
        } else if (check.containsKey("minLength")) {
            return check.get("minLength").test(object);
        } else if (check.containsKey("contains")) {
            return check.get("contains").test(object);
        }
        return true;
    }
}


