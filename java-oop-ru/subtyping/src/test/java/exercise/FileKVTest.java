package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    void FileKV() {
        KeyValueStorage storage = new FileKV(String.valueOf(filepath), Map.of("key", "value"));
        storage.set("key2", "value2");


        assertThat(storage.get("key3", "default")).isEqualTo("default");
        assertThat(storage.get("key", "")).isEqualTo("value");
        assertThat(storage.get("key2", "")).isEqualTo("value2");
    }


    // END
}
