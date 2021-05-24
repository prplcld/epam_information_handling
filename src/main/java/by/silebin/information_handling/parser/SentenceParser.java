package by.silebin.information_handling.parser;

import by.silebin.information_handling.entity.AbstractComponent;
import by.silebin.information_handling.entity.Sentence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(SentenceParser.class.getName());
    private static final String SPLIT_REGEX = "[.?!]\\s|[.?!]";

    @Override
    public void parse(AbstractComponent component, String text) {
        LOGGER.info("sentence parser");
        for (String s : text.split(SPLIT_REGEX)) {
            Sentence sentence = new Sentence();
            component.add(sentence);
            nextParser.parse(sentence, s);
        }
    }
}
