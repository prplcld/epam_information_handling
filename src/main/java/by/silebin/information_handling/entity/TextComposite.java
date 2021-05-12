package by.silebin.information_handling.entity;

public class TextComposite extends Composite {

    private static final String SEPARATOR = "\t";

    @Override
    public String getText() {
        StringBuilder text = new StringBuilder();
        for (Component c : children) {
            text.append(SEPARATOR)
                    .append(c.getText());
        }
        return text.toString();
    }
}
