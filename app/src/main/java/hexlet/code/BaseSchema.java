package hexlet.code;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Predicate;

public abstract class BaseSchema {
    static Map<String, Predicate<Object>> check = new LinkedHashMap<>();
    protected final void addCheck(String name, Predicate<Object> validate) {
        check.put(name, validate);
    }


    public abstract BaseSchema minLength(int minLength);
    public abstract BaseSchema contains(String contains);
    public abstract Boolean isValid(Object object);

}

