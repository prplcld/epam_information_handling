package by.silebin.information_handling.entity;

public class Text extends AbstractComposite {
    private static final String PREFIX = "\t";
    private static final String SEPARATOR = "\n";

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (AbstractComponent c : children) {
            text.append(PREFIX).append(c).append(SEPARATOR);
        }
        return text.toString();
    }
}
