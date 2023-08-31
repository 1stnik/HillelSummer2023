package com.hillel.lesson_30.ex;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ListRemove {

    /*
    Название ConcurrentModificationException многих вводит в заблуждение. При слове Concurrent
    первое что приходит на ум — многотредность. Однако, данное исключение относится вовсе не к
    многотредности. Исключение может происходить при работе с коллекциями при обычной однотредной
    работе.

    Для «прохода» по коллекции используются структуры данных, реализующие паттерн «View». Структуры
    данных эти называются итераторами и могут использоваться явно и не явно. Неявно итераторы
    используются при использовании конструкции foreach.

    ConcurrentModificationException возникает когда коллекция модифицируется «одновременно» с
    проходом по коллекции итератором любыми средствами кроме самого итератора.


     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       var values = new ArrayList<Integer>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);

        // не явный итератор
        for (Integer val : values) {
            values.remove(val);
        }
        System.out.println(values);
    }
}
