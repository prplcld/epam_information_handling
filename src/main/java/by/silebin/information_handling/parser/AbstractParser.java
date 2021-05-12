package by.silebin.information_handling.parser;

import by.silebin.information_handling.entity.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractParser {

    protected AbstractParser nextParser = DefaultParser.getParser();

    public void setNextParser(AbstractParser nextParser) {
        this.nextParser = nextParser;
    }

    public abstract void parse(Component component, String text);


    private static class DefaultParser extends AbstractParser {

        private static final Logger LOGGER = LogManager.getLogger(DefaultParser.class.getName());

        private static DefaultParser parser  = new DefaultParser();

        public static DefaultParser getParser(){
            return parser;
        }

        @Override
        public void parse(Component component, String text) {
            LOGGER.info("end of chain");
        }
    }
}
