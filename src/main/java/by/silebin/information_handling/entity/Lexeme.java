package by.silebin.information_handling.entity;

public class Lexeme extends AbstractComposite {

    private static final String SEPARATOR = "";

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (AbstractComponent c : children) {
            text.append(SEPARATOR)
                    .append(c);
        }
        return text.toString();
    }
}
