package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> children;

    public PairedTag(String tagName, Map<String, String> keysValues, String tagBody, List<Tag> children) {
        super(tagName, keysValues);
        this.tagBody = tagBody;
        this.children = children;
    }

    @Override
    public String toString() {
        // Создаем открывающий тег
        var singleTag = new SingleTag(getTagName(), getKeysValues()).toString();

        // Добавляем тело тега
        String result = singleTag + tagBody;

        // Обрабатываем children
        if (children != null && !children.isEmpty()) {
            String childrenContent = children.stream()
                    .map(Tag::toString)
                    .collect(Collectors.joining());
            result += childrenContent;
        }

        // Добавляем закрывающий тег
        result += "</" + getTagName() + ">";

        return result;
    }
}
// END