package hexlet.code;

public class Validator {
    public StringSchema string() {
        NumberSchema.check.clear();
        return new StringSchema();
    }
    public NumberSchema number() {
        NumberSchema.check.clear();
        return new NumberSchema();
    }
}
