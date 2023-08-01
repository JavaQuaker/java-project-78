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
        check.put("required", str -> str instanceof String && !((String) str).isEmpty());
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
        if ((object == null) & (!check.containsKey("required"))) {
            return true;
        } else if ((object == null) & (check.containsKey("required"))) {
            return false;
        }
        if ((object.equals("") & (!check.containsKey("required")))) {
            return true;
        } else if ((object.equals("") & (check.containsKey("required")))) {
            return false;
        } else if ((!check.containsKey("required") & (!check.containsKey("minLength")
                & (!check.containsKey("contains"))))) {
            return true;
        } else if ((check.containsKey("required") & (!check.containsKey("minLength")
                & (!check.containsKey("contains"))))) {
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


