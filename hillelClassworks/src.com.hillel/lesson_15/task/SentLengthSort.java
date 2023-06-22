package lesson_15.task;

import java.util.Arrays;
import java.util.stream.Collectors;

//2.   Вывести все предложения заданного текста в порядке возрастания количества слов в
//        каждом из них.
public class SentLengthSort {
    public static void main(String[] args) {
        System.out.println("1 2 3. 2 3 4. 3 4 5. 6 7");
        sortByLength("1 2 3. 2 3 4. 3 4 5. 6 7");
    }

    private static void sortByLength(String text) {

        String ls =
                Arrays.stream(text.split("\\. "))
                        .map(e -> {
                            String[] arr = e.split(" ");
                            return new Sent(arr.length, e);
                        })
                        .collect(Collectors.groupingBy(Sent::getwCount))
                        .values().stream()
                        .map(sents -> sents.stream().map(Sent::getValue).collect(Collectors.joining(". ")))
                        .collect(Collectors.joining(". "));
        System.out.println(ls);
    }
}

class Sent {
    private int wCount;
    private String value;

    public Sent(int wCount, String value) {
        this.wCount = wCount;
        this.value = value;
    }

    public int getwCount() {
        return wCount;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Sent{" +
                "wCount=" + wCount +
                ", value='" + value + '\'' +
                '}';
    }
}
