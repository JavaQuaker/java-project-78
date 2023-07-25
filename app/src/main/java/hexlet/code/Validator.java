package hexlet.code;

public class Validator extends StringSchema {
    public Boolean isValid(Object object) {
        if (!required) {
            return true;
        }
        if (check.get("required").equals(true)) {
            return true;
        }
        if (check.get("minLength").equals(true)) {
            return true;
        }
        if (check.get("contains").equals(true)) {
            return true;
        }
        return false;
    }
    public StringSchema contains(String string) {
        return new StringSchema();
    }
    public StringSchema string() {
        StringSchema schema = new StringSchema();
        return schema;
    }

}
