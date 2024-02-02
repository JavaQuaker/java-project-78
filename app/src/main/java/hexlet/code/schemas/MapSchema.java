package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
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
}
