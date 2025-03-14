package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String tagName, Map<String, String> keysValues) {
        super(tagName, keysValues);
    }

    public SingleTag() {
        super();
    }

    @Override
    public String toString() {
        return "<" + getTagName() + createBody() + ">";
    }

    public String createBody() {
        StringBuilder temp = new StringBuilder();
        for (var key : getKeysValues().keySet()) {
            temp.append(" ")
                    .append(key)
                    .append("=")
                    .append("\"")
                    .append(getKeysValues().get(key))
                    .append("\"");
        }
        return temp.toString();
    }
}
// END