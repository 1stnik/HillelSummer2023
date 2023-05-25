package lesson_09;

import java.util.List;

public class LIstOf {

    public static void main(String[] args) {
        List<String> str = List.of("1", "2");

        System.out.println(str.getClass().getSimpleName());
    }
}
