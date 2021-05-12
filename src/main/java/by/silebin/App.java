package by.silebin;

import by.silebin.information_handling.entity.TextComposite;
import by.silebin.information_handling.parser.LexemeParser;
import by.silebin.information_handling.parser.ParagraphParser;
import by.silebin.information_handling.parser.SentenceParser;
import by.silebin.information_handling.parser.SymbolParser;

public class App 
{
    public static void main( String[] args )
    {
        SymbolParser symbolParser = new SymbolParser();
        LexemeParser lexemeParser = new LexemeParser();
        SentenceParser sentenceParser = new SentenceParser();
        ParagraphParser paragraphParser = new ParagraphParser();

        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
        lexemeParser.setNextParser(symbolParser);

        paragraphParser.parse(new TextComposite(), "");
    }
}
