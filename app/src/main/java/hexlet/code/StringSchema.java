package hexlet.code;

public class StringSchema {
    StringSchema() {

    }
    static String str;

    // проверка на пустоту
    public static Boolean required(String string) {
      if (Validator.isValid(str).isEmpty()) {
          return false;
      }
      return true;
    }
    // ограничение минимальной длины
    public static Boolean minLength(int minLength) {
        if (str.length() < minLength) {
            return false;
        }
       return true;
    }
    // ограничение содержимого строки
    public static Boolean contains(String string) {
        if (str.contains(string)) {
            return true;
        }
        return false;
    }
}
