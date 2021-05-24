package by.silebin.information_handling.parser;

import by.silebin.information_handling.entity.AbstractComponent;
import by.silebin.information_handling.entity.Symbol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(Symbol.class.getName());

    @Override
    public void parse(AbstractComponent component, String text) {
        LOGGER.info("symbol parser");
        for (char c : text.toCharArray()) {
            component.add(new Symbol(c));
        }
    }
}
