package lesson_15.classTasks;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

// 10.  Существует текст и список слов. Для каждого слова из заданного списка найти,
// сколько раз оно встречается в каждомпредложении, и рассортировать слова по
// убыванию общего количества вхождений.
public class T10 {

    public static void main(String[] args) {

        String str = StringTest.TEXT_R;

//        str = str
//                .replaceAll("\\p{Z}", "") // удаление пробелов
//                .replaceAll("\\p{P}", "") // удаление знаков припинапия
//                .toLowerCase(); // перевод в нижний регистр
//
//        System.out.println(str);
//
//        Map<String, List<String>> collect1 =
//                Arrays.stream(str.split("")).
//                collect(Collectors.groupingBy((e -> e)));

//        System.out.println(collect1);

//        Map<String, Integer> collect = collect1.
//                entrySet()
//                .stream()
//                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().size()));
//
//        System.out.println(collect);


//        // variant 1
//
//        System.out.println(Arrays.stream(StringTest.TEXT_R
//                        .replaceAll("\\p{Z}", "")
//                        .replaceAll("\\p{P}", "")
//                        .toLowerCase()
//                        .split(""))
//                .collect(Collectors.groupingBy((e -> e))) // группирует значения по буквам
//                .entrySet()// стрими по ентри сету
//                .stream()
//                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().size())));
//
//
        // variant 2

        System.out.println(Arrays.stream(StringTest.TEXT_R
                        .replaceAll("\\p{Z}", "")
                        .replaceAll("\\p{P}", "")
                        .toLowerCase()
                        .split(""))
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }
}
