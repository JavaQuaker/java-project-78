package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberSchemaTest {
    @Test
    public void numberSchemaTest() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.positive().isValid(null)).isTrue();
        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.positive().isValid(5)).isTrue();
        assertThat(schema.positive().isValid(-1)).isFalse();
        assertThat(schema.positive().isValid(0)).isFalse();
        assertThat(schema.range(2, 7).isValid(5)).isTrue();
        assertThat(schema.range(2, 7).isValid(2)).isTrue();
        assertThat(schema.range(2, 7).isValid(1)).isFalse();
        assertThat(schema.isValid("2")).isFalse();
    }
}
