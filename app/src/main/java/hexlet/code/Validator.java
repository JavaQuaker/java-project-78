package hexlet.code;

public class Validator {
    Validator() {

    }
    public static StringSchema string() {
        StringSchema schema = new StringSchema();
        return schema;
    }
    public static String isValid(String string) {
       return string;
    }
    public static int isValid(int value) {
        return value;
    }
    Validator v = new Validator();
    StringSchema schema = v.string();
}
