package hexlet.code;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class StringSchemaTest {


    @Test
    public void isValidTest() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();
    }


    @Test
    public void requiredTest() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid(5)).isFalse();
        assertThat(schema.isValid("what does the fox say")).isFalse();
        assertThat(schema.isValid("hexlet")).isFalse();
        assertThat(schema.contains("wh").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("what").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isFalse();
    }

    @Test
    public void requiredTestMinLength() {
        Validator v = new Validator();
        StringSchema schema = v.string().minLength(5);
        schema.required();
        assertThat(schema.isValid("qwert")).isTrue();
    }

    @Test
    public void requiredTestContains() {
        Validator v = new Validator();
        StringSchema schema = v.string().contains("qwe");
        schema.required();
        assertThat(schema.isValid("qwerty")).isTrue();
    }

    @Test
    public void requiredTestMinLengthContains() {
        Validator v = new Validator();
        StringSchema schema = v.string().minLength(6).contains("qwe");
        schema.required();
        assertThat(schema.isValid("qwerty")).isTrue();
    }


    @Test
    public void containsTest() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();
        assertThat(schema.contains("wh").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("what").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isFalse();

    }
}

