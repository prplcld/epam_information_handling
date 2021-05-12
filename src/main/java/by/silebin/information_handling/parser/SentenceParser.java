package by.silebin.information_handling.parser;

import by.silebin.information_handling.entity.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(SentenceParser.class.getName());

    @Override
    public void parse(Component component, String text) {
        LOGGER.info("sentence parser");
        nextParser.parse(component, text);
    }
}
