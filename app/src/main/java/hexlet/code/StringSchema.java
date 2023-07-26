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
        check.put("required", str -> false);
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
        if (!check.containsKey("required") & (check.get("minLength") == null) | (check.get("contains") == null)) {
            return true;
        }
        if (check.containsKey("required") & (check.get("minLength") == null)
                | (check.get("contains") == null)) {
            return false;
        }

        return true;


//        if (check.get("minLength").test(stringLength)) {
//            return true;
//        }
//        if (check.get("contains").test(count)) {
//            return true;

    }
}


