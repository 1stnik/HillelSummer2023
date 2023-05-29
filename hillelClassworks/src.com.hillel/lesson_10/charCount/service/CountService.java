package lesson_10.charCount.service;


import java.util.List;
import java.util.Map;
import lesson_10.charCount.Letter;

public interface CountService {

    String normalizeText(String text);

    Map<String, Integer> createDictionary(String text);

    List<Letter> convertMapToList(Map<String, Integer> dictionary, String text);
}
