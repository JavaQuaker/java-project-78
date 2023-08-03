package hexlet.code;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapSchemaTest {
    @Test
    public void mapSchemaTest() {

        Validator v = new Validator();
        MapSchema schema = v.map();
        assertThat(schema.isValid(null)).isTrue();
        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap<>())).isTrue();
        Map<String, String> map = new HashMap<>();
        map.put("key1", "data1");
        assertThat(schema.isValid(map)).isTrue();
        schema.sizeof(2);
        assertThat(schema.isValid(map)).isFalse();
        map.put("key2", "data2");
        assertThat(schema.isValid(map)).isTrue();
    }
}
