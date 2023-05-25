package lesson_09.task;

import java.util.Arrays;
import java.util.Objects;

//Дан массив целых чисел и ещё одно целое число. Удалите все вхождения этого числа из массива
//(пропусков быть не должно). 1 2 3 4 5 6 4 5 4 - (4) -> 1 2 3 5 6 5
public class NumberRemover {

    public static void main(String[] args) {
        Integer[] mass = {1, 2, 3, 4, 5, 4, 5, 6, 4};
        System.out.println(Arrays.deepToString(removeNumberFromArray(mass, 5)));
    }

    public static Integer[] removeNumberFromArray(Integer[] mass, Integer value) {
        int count = 0;
        // count value
        for (Integer i : mass) {
            if (Objects.equals(i, value)) {
                count++;
            }
        }
        // new array
        Integer[] result = new Integer[mass.length - count];
        int i = 0;
        int j = 0;
        // copy values to new array by if
        for (; i < mass.length; i++){
            if (!Objects.equals(mass[i], value)) {
                result[j++] = mass[i];
            }
        }
        return result;
    }
}
