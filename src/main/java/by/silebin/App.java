package by.silebin;

import by.silebin.information_handling.entity.Text;
import by.silebin.information_handling.parser.LexemeParser;
import by.silebin.information_handling.parser.ParagraphParser;
import by.silebin.information_handling.parser.SentenceParser;
import by.silebin.information_handling.parser.SymbolParser;
import by.silebin.information_handling.util.PostfixCalculator;
import by.silebin.information_handling.util.PostfixConverter;

public class App {
    public static void main( String[] args ) {
        SymbolParser symbolParser = new SymbolParser();
        LexemeParser lexemeParser = new LexemeParser();
        SentenceParser sentenceParser = new SentenceParser();
        ParagraphParser paragraphParser = new ParagraphParser();

        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
        lexemeParser.setNextParser(symbolParser);

        Text text = new Text();

        paragraphParser.parse(text, "\tIt has survived - not only (five) centuries, but also the leap into 13<<2 electronic\n" +
                "typesetting, remaining 3>>5 essentially ~6&9|(3&4) unchanged. It was popularised in the\n" +
                "5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1) with the release of Letraset sheets containing\n" +
                "Lorem Ipsum passages, and more recently with desktop publishing software like Aldus\n" +
                "PageMaker including versions of Lorem Ipsum.\n" +
                "\tIt is a long established fact that a reader will be distracted by the readable content of a\n" +
                "page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78\n" +
                "Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content\n" +
                "here), content here', making it look like readable English.\n" +
                "\tIt is a (7^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page\n" +
                "when looking at its layout.\n" +
                "\tBye.");

        System.out.println(text);


//        PostfixCalculator postfixCalculator = new PostfixCalculator();
//        postfixCalculator.parseExpression(PostfixConverter.convert("13<<2"));
//        System.out.println(PostfixConverter.convert("13<<2"));
//        System.out.println(postfixCalculator.calculate());
//        int a = 13<<2;
//        System.out.println(a);
    }
}
