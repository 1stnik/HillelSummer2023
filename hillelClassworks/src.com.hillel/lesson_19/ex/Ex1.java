package lesson_19.ex;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add( 0 , 'E' );
        list.add( 'X' );
        list.add( 1 , 'P' );
        list.add( 3 , 'O' );
        if (list.contains( 'O' )) {
//            list.remove(  'O' );
            list.remove( (Character) 'O' ); // index not element
        }
        for ( char ch : list) {
            System. out .print(ch);
        }
    }
}
