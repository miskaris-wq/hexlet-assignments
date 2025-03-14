package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private String tagName;
    private Map<String, String> keysValues;

    public Tag(String tagName, Map<String, String> keysValues) {
        this.tagName = tagName;
        this.keysValues = keysValues;
    }

    public Tag() {

    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Map<String, String> getKeysValues() {
        return keysValues;
    }

    public void setKeysValues(Map<String, String> keysValues) {
        this.keysValues = keysValues;
    }
}
// END
