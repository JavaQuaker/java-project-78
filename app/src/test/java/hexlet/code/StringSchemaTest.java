package hexlet.code;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringSchemaTest {
    @Test
    public void isValidTest() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        assertThat(schema.isValid("")).isTrue();
    }
    @Test
    public void isValidTestNull() {
        Validator v = new Validator();
        StringSchema schema = v.string();
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
        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("hexlet")).isTrue();

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
