package lesson_10.charCount;

/*
a - 10
b - 15
c - 20
 */



import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lesson_10.charCount.service.CountService;
import lesson_10.charCount.service.CountServiceImpl;

public class RunCount {
    public static void main(String[] args) {
        CountService cs = new CountServiceImpl();
        String text = cs.normalizeText(Text.getText());
        Map<String, Integer> dictionary = cs.createDictionary(text);
        List<Letter> letters = cs.convertMapToList(dictionary, text);

        letters.sort(Comparator.comparing(Letter::getPercent).reversed());
        letters.forEach(System.out::println);


    }

}

