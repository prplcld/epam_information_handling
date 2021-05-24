package by.silebin.information_handling.parser;

import by.silebin.information_handling.entity.AbstractComponent;
import by.silebin.information_handling.entity.AbstractComposite;
import by.silebin.information_handling.entity.Paragraph;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(ParagraphParser.class.getName());


    @Override
    public void parse(AbstractComponent component, String text) {
        LOGGER.info("paragraph parser");

        String[] paragraphs = text.split("\\t");
        for (String p : paragraphs) {
            if (p.equals("")) {
                continue;
            }
            AbstractComposite paragraph = new Paragraph();
            component.add(paragraph);
            nextParser.parse(paragraph, p);
        }
    }
}
