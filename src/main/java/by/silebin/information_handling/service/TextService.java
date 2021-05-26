package by.silebin.information_handling.service;

import by.silebin.information_handling.entity.AbstractComponent;
import by.silebin.information_handling.exception.TextServiceException;
import by.silebin.information_handling.exception.WrongCompositeTypeException;

import java.util.List;
import java.util.Map;

public interface TextService {
    List<AbstractComponent> sortParagraphsBySentenceAmount(AbstractComponent component) throws WrongCompositeTypeException;
    AbstractComponent getSentenceWithLongestWord(AbstractComponent component) throws WrongCompositeTypeException, TextServiceException;
    Map<String, Integer> getWordOccurrences(AbstractComponent component) throws WrongCompositeTypeException;
    long countVowels(AbstractComponent component) throws WrongCompositeTypeException;
    long countConsonants(AbstractComponent component) throws WrongCompositeTypeException;
}
