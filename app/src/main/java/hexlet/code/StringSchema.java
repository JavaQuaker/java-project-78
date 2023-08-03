package hexlet.code;



import java.util.Map;


import java.util.function.Predicate;

public class StringSchema extends BaseSchema {
//    static Map<String, Predicate<Object>> check = new LinkedHashMap<>();


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
    public Boolean isValid(Object object) {
        if ((object == null) & (!check.containsKey("required"))) {
            return true;
        } else if ((object == null) & (check.containsKey("required"))) {
            return false;
        } else if (!(object instanceof String)) {
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


