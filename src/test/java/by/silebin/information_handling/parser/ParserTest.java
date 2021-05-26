package by.silebin.information_handling.parser;

import by.silebin.information_handling.entity.AbstractComponent;
import by.silebin.information_handling.entity.Text;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class ParserTest {

    private AbstractParser parser;
    private static String expected;

    static {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL resource = classLoader.getResource("data/parsed_data.txt");
        String fileAbsolutePath = new File(resource.getFile()).getAbsolutePath();
        Path path = Path.of(fileAbsolutePath);
        try {
            expected = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void init() {
        SymbolParser symbolParser = new SymbolParser();
        LexemeParser lexemeParser = new LexemeParser();
        SentenceParser sentenceParser = new SentenceParser();
        ParagraphParser paragraphParser = new ParagraphParser();

        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
        lexemeParser.setNextParser(symbolParser);

        parser = paragraphParser;
    }

    @Test
    public void testParse() throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL resource = classLoader.getResource("data/test_data.txt");
        String fileAbsolutePath = new File(resource.getFile()).getAbsolutePath();
        Path path = Path.of(fileAbsolutePath);
        String text = Files.readString(path);
        AbstractComponent textComponent = new Text();
        parser.parse(textComponent, text);
        Assert.assertEquals(textComponent.toString(), expected);
    }
}
