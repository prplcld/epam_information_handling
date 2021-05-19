package by.silebin;

import by.silebin.information_handling.entity.TextComposite;
import by.silebin.information_handling.parser.LexemeParser;
import by.silebin.information_handling.parser.ParagraphParser;
import by.silebin.information_handling.parser.SentenceParser;
import by.silebin.information_handling.parser.SymbolParser;
import by.silebin.information_handling.util.PostfixCalculator;
import by.silebin.information_handling.util.PostfixConverter;

public class App {
    public static void main( String[] args ) {
//        SymbolParser symbolParser = new SymbolParser();
//        LexemeParser lexemeParser = new LexemeParser();
//        SentenceParser sentenceParser = new SentenceParser();
//        ParagraphParser paragraphParser = new ParagraphParser();
//
//        paragraphParser.setNextParser(sentenceParser);
//        sentenceParser.setNextParser(lexemeParser);
//        lexemeParser.setNextParser(symbolParser);
//
//        paragraphParser.parse(new TextComposite(), "");


        PostfixCalculator postfixCalculator = new PostfixCalculator(PostfixConverter.convert("(7^5|1&2<<(2|5>>2&71))|1200"));
        System.out.println(postfixCalculator.calculate());
        int a = (7^5|1&2<<(2|5>>2&71))|1200;
        System.out.println(a);
    }
}
