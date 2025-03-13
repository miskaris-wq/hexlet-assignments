package exercise;

// BEGIN
public class LabelTag implements TagInterface{
    private String text;
    private TagInterface child;

    public LabelTag(String text, TagInterface child) {
        this.text = text;
        this.child = child;
    }

    @Override
    public String render() {
        return "<label>" + text + child.render() + "</label>";
    }

}
// END
