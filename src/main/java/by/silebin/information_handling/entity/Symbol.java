package by.silebin.information_handling.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

public class Symbol extends AbstractComponent {

    private static final Logger LOGGER = LogManager.getLogger(Symbol.class.getName());

    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void add(AbstractComponent component) {
        LOGGER.info("unsupported operation");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(AbstractComponent component) {
        LOGGER.info("unsupported operation");
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<AbstractComponent> getChildren() {
        LOGGER.info("unsupported operation");
        throw new UnsupportedOperationException();
    }

    @Override
    public int countElements() {
        return 1;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
