package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected Map<String, Predicate<Object>> check = new LinkedHashMap<>();

    public abstract void addCheck(String name, Predicate<Object> validate);

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


        }
        return check.values().stream()
                .allMatch(x -> x.test(object));
    }
}









