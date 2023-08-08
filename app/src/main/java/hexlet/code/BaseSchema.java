package hexlet.code;

import java.util.function.Predicate;

public abstract class BaseSchema {

    public abstract void addCheck(String name, Predicate<Object> validate);
    public abstract Boolean isValid(Object object);


}

