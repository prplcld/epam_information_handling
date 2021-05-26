package by.silebin.information_handling.service.impl;

import by.silebin.information_handling.entity.AbstractComponent;
import by.silebin.information_handling.entity.Sentence;
import by.silebin.information_handling.entity.Text;
import by.silebin.information_handling.exception.TextServiceException;
import by.silebin.information_handling.exception.WrongCompositeTypeException;
import by.silebin.information_handling.service.TextService;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextServiceImpl implements TextService {

    private static final String VOWELS_REGEX = "[aAeEiIoOuU]";
    private static final String CONSONANTS_REGEX = "[^aAeEiIoOuU]";

    private static class ParagraphComparator implements Comparator<AbstractComponent> {
        @Override
        public int compare(AbstractComponent first, AbstractComponent second) {
            int firstCount = first.countElements();
            int secondCount = second.countElements();

            return Integer.compare(firstCount, secondCount);
        }
    }

    private static class SentenceComparator implements Comparator<AbstractComponent> {
        @Override
        public int compare(AbstractComponent first, AbstractComponent second) {
            Optional<AbstractComponent> firstLongestWord = first.getChildren()
                    .stream()
                    .max(Comparator.comparingInt(AbstractComponent::countElements));

            Optional<AbstractComponent> secondLongestWord = second.getChildren()
                    .stream()
                    .max(Comparator.comparingInt(AbstractComponent::countElements));

            int firstLength = 0;
            int secondLength = 0;


            if(firstLongestWord.isPresent()) {
                firstLength = firstLongestWord.get().countElements();
            }

            if (secondLongestWord.isPresent()) {
                secondLength = secondLongestWord.get().countElements();
            }

            return Integer.compare(firstLength, secondLength);
        }
    }

    @Override
    public List<AbstractComponent> sortParagraphsBySentenceAmount(AbstractComponent component) throws WrongCompositeTypeException {
        if (!(component instanceof Text)) {
            throw new WrongCompositeTypeException();
        }

        List<AbstractComponent> paragraphs = component.getChildren()
                .stream()
                .sorted(new ParagraphComparator())
                .collect(Collectors.toList());
        return paragraphs;
    }

    @Override
    public AbstractComponent getSentenceWithLongestWord(AbstractComponent component) throws WrongCompositeTypeException, TextServiceException {
        if(!(component instanceof Text)) {
            throw new WrongCompositeTypeException();
        }

        Optional<AbstractComponent> sentence = component.getChildren()
                .stream()
                .flatMap(c -> c.getChildren().stream()).max(new SentenceComparator());

        return sentence.orElseThrow(TextServiceException::new);

    }

    @Override
    public Map<String, Integer> getWordOccurrences(AbstractComponent component) throws WrongCompositeTypeException {
        if(!(component instanceof Text)) {
            throw new WrongCompositeTypeException();
        }
        Map<String, Integer> wordOccurrences = new HashMap<>();
        component.getChildren()
                .stream()
                .flatMap(c -> c.getChildren().stream())
                .flatMap(c -> c.getChildren().stream())
                .forEach(c -> {
                    int amount = wordOccurrences.getOrDefault(c.toString().toLowerCase(), 0);
                    wordOccurrences.put(c.toString().toLowerCase(), ++amount);
                });
        return wordOccurrences;
    }

    @Override
    public long countVowels(AbstractComponent component) throws WrongCompositeTypeException {
        if(!(component instanceof Sentence)) {
            throw  new WrongCompositeTypeException();
        }

        long vowelsAmount = component.getChildren()
                .stream()
                .flatMap(c -> c.getChildren().stream())
                .filter(c -> Pattern.matches(VOWELS_REGEX, c.toString()))
                .count();

        return vowelsAmount;
    }

    @Override
    public long countConsonants(AbstractComponent component) throws WrongCompositeTypeException {
        if(!(component instanceof Sentence)) {
            throw  new WrongCompositeTypeException();
        }

        long consonantsAmount = component.getChildren()
                .stream()
                .flatMap(c -> c.getChildren().stream())
                .filter(c -> Pattern.matches(CONSONANTS_REGEX, c.toString()))
                .count();

        return consonantsAmount;
    }
}
