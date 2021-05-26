package by.silebin.information_handling.parser;

import by.silebin.information_handling.entity.AbstractComponent;
import by.silebin.information_handling.entity.Lexeme;
import by.silebin.information_handling.exception.PostfixCalculatorException;
import by.silebin.information_handling.util.PostfixCalculator;
import by.silebin.information_handling.util.PostfixConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(LexemeParser.class.getName());
    private static final String LEXEME_SPLIT = "\\s|\n";
    private static final String BIT_LEXEME_REGEX = "^[~(\\d]([^a-zA-Z])+[~)\\d]$";

    @Override
    public void parse(AbstractComponent component, String text) {
        LOGGER.info("lexeme parser");
        for(String l : text.split(LEXEME_SPLIT)) {
            if(l.equals("")){
                continue;
            }
            if(l.matches(BIT_LEXEME_REGEX)) {
                PostfixCalculator postfixCalculator = new PostfixCalculator();
                String postfixExpression = PostfixConverter.convert(l);
                postfixCalculator.parseExpression(postfixExpression);
                int result = 0;
                try {
                    result = postfixCalculator.calculate();
                } catch (PostfixCalculatorException e) {
                    e.printStackTrace();
                }
                Lexeme lexeme = new Lexeme();
                component.add(lexeme);
                nextParser.parse(lexeme, String.valueOf(result));
            } else {
                Lexeme lexeme = new Lexeme();
                component.add(lexeme);
                nextParser.parse(lexeme, l);
            }
        }
    }
}
