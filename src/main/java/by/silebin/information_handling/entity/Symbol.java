package by.silebin.information_handling.entity;

public class Symbol implements Component {

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
    public String getText() {
        return String.valueOf(symbol);
    }

    @Override
    public int countElements() {
        return 1;
    }
}
