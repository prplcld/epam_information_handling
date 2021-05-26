package by.silebin.information_handling.entity;

public class Paragraph extends AbstractComposite {

    private static final String SEPARATOR = ". ";

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (AbstractComponent c : children) {
            text.append(c)
                    .append(SEPARATOR);
        }
        return text.toString().trim();
    }


}
