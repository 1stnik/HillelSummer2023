package lesson_15.task;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

// Напечатать слова текста в алфавитном порядке по первой букве.
public class AlphaberOrder {

    public final static String TEXT_E = "lorem ipsum dolor sit amet consectetur adipiscing elit vitae accumsan cursus ligula lacinia semper parturient iaculis dictum sapien scelerisque hac penatibus fringilla purus placerat magna condimentum lobortis eget feugiat nostra maecenas finibus leo faucibus sem commodo tempus cras rutrum hendrerit montes convallis libero ut aliquet arcu ac posuere sociosqu varius massa aliquam vivamus malesuada lectus consequat at viverra eleifend primis pretium tellus potenti dis ridiculus euismod himenaeos senectus urna suspendisse egestas ante sodales blandit diam curae eros volutpat dignissim justo molestie suscipit etiam phasellus quis tortor felis luctus laoreet habitant mi gravida mollis id vulputate mattis a neque fames";


    public static void main(String[] args) {
//        Arrays.stream(TEXT_E.split(" ")).sorted().forEach(s -> System.out.print(s + " "));

        Stream.of(1,4,56,3,2,4,5,2,6,9,0).sorted(Comparator.reverseOrder()).forEach(System.out::println);

        Integer max = Stream.of(1, 4, 56, 3, 2, 4, 5, 2, 6, 9, 0).max(Integer::compareTo).get();

        System.out.println(max);
    }

}
