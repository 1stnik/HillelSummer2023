package lesson_09.hw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HW10 {

    // 1
    public int countOccurance(List<String> list, String pattern){
        return 0;
    }
    private List<String> getList(List<String> words, int count){
        return new ArrayList<>();
    }

    private String getRandomWord(List<String> words){
        return words.get((int) (Math.random()*10));
    } // 0 .. 10

    // 2 -> for / while

    // 3 - to Set

    public Set<Integer> uniqueValues(List<Integer> values){
        return new HashSet<>(values);
    }

}
