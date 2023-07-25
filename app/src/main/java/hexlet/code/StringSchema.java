package hexlet.code;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class StringSchema extends BaseClass {
    static Map<String, Predicate> check = new LinkedHashMap<>();

    static boolean required;
    private int minLength;
    private String contains;

    @Override
    public StringSchema string() {
        return null;
    }

    // проверка на пустоту
   public StringSchema required() {
        this.required = true;
        check.put("required", r -> Objects.equals(r, null));
        return this;
   }
    // ограничение минимальной длины
    public StringSchema minLength(int minLength) {
        this.minLength = minLength;
       check.put("minLength", (Predicate<String>) str -> str.length() >= minLength);
        return this;
    }
    // ограничение содержимого строки
    public StringSchema contains(String contains) {
        this.contains = contains;
        check.put("contains", (Predicate<String>) str -> str.contains(contains));
        return this;
    }

    @Override
    public Boolean isValid(Object object) {
        return true;
    }

}
