package hexlet.code;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    protected Map<String, Predicate<Object>> check = new LinkedHashMap<>();
    public void addCheck(String name, Predicate<Object> validate) {
        check.put(name, validate);
    }

    public MapSchema required() {
        addCheck("required", value -> {
            if ((value instanceof Map) & (value != null) & (check.containsKey("required"))) {
                return true;
            } else {
                return value instanceof Map;
            }
        });
        return this;
    }
    public MapSchema sizeof(int countMap) {
        addCheck("sizeof", value -> ((Map<?, ?>) value).size() == countMap);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        addCheck("shape", value -> {
            for (Map.Entry<String, BaseSchema> result : map.entrySet()) {
                if (result.getValue().isValid(((Map<?, ?>) value).get(value))) {
                    return true;
                }
            }
            return false;
        });
        return this;
    }

    @Override
    public Boolean isValid(Object object) {
        if ((object == null) & (!check.containsKey("required"))) {
            return true;
        } else if ((object == null) & (check.containsKey("required"))) {
            return false;
        } else if (!(object instanceof Map)) {
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
