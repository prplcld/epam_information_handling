package by.silebin.information_handling.parser;

import by.silebin.information_handling.entity.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(ParagraphParser.class.getName());

    @Override
    public void parse(Component component, String text) {
        LOGGER.info("paragraph parser");
        nextParser.parse(component, text);
    }
}
