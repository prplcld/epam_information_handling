package by.silebin.information_handling.parser;

import by.silebin.information_handling.entity.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(LexemeParser.class.getName());


    @Override
    public void parse(Component component, String text) {
        LOGGER.info("lexeme parser");
        nextParser.parse(component, text);
    }
}
