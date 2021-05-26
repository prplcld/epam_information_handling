package by.silebin.information_handling.service;

import by.silebin.information_handling.entity.AbstractComponent;
import by.silebin.information_handling.entity.Sentence;
import by.silebin.information_handling.entity.Text;
import by.silebin.information_handling.exception.TextServiceException;
import by.silebin.information_handling.exception.WrongCompositeTypeException;
import by.silebin.information_handling.parser.LexemeParser;
import by.silebin.information_handling.parser.ParagraphParser;
import by.silebin.information_handling.parser.SentenceParser;
import by.silebin.information_handling.parser.SymbolParser;
import by.silebin.information_handling.service.impl.TextServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextServiceTest {

    private AbstractComponent textComponent = new Text();
    private TextService textService;
    private Sentence sentence;

    private List<Integer> expectedWordCounts = new ArrayList<>() {
        {add(1);}
        {add(2);}
        {add(2);}
    };

    private Map<String, Integer> expectedMap = new HashMap<>() {
        {
            put("aa", 2);
            put("bb", 2);
            put("c", 2);
            put("aaa", 1);
            put("que", 1);
            put("bbbbbbbb", 1);
            put("bye", 1);
        }
    };

    @BeforeTest
    public void init() throws IOException, TextServiceException {
        SymbolParser symbolParser = new SymbolParser();
        LexemeParser lexemeParser = new LexemeParser();
        SentenceParser sentenceParser = new SentenceParser();
        ParagraphParser paragraphParser = new ParagraphParser();

        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
        lexemeParser.setNextParser(symbolParser);

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL resource = classLoader.getResource("data/small_test_data.txt");
        String fileAbsolutePath = new File(resource.getFile()).getAbsolutePath();
        Path path = Path.of(fileAbsolutePath);
        String text = Files.readString(path);
        paragraphParser.parse(textComponent, text);
        textService = new TextServiceImpl();

        sentence = (Sentence) textComponent.getChildren().stream()
                .flatMap(c -> c.getChildren().stream())
                .findFirst()
                .orElseThrow(TextServiceException::new);
    }

    @Test
    public void testCountVowels() throws WrongCompositeTypeException {
        long vowelsAmount = textService.countVowels(sentence);
        Assert.assertEquals(vowelsAmount, 2);
    }

    @Test
    public void TestCountConsonants() throws WrongCompositeTypeException {
        long consonantsAmount = textService.countConsonants(sentence);
        Assert.assertEquals(consonantsAmount, 3);
    }

    @Test
    public void testGetWordOccurrences() throws WrongCompositeTypeException {
        Map<String, Integer> actual = textService.getWordOccurrences(textComponent);
        Assert.assertEquals(actual, expectedMap);
    }

    @Test
    public void testGetSentenceWithLongestWord() throws TextServiceException, WrongCompositeTypeException {
        AbstractComponent sentence = textService.getSentenceWithLongestWord(textComponent);
        Assert.assertEquals(sentence.toString(), "Aa bbbbbbbb");
    }

    @Test
    public void testSortParagraphsBySentenceAmount() throws WrongCompositeTypeException {
        List<Integer> wordsCount = textService.sortParagraphsBySentenceAmount(textComponent)
                .stream()
                .map(c -> c.countElements())
                .collect(Collectors.toList());

        Assert.assertEquals(wordsCount, expectedWordCounts);
    }
}
