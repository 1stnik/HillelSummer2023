package lesson_19.ex;

import java.util.LinkedList;

public class Ex4 {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.show();
    }
}
class Demo {
    public void show() {
        LinkedList<String> list = new LinkedList<>();
//        list.add(null);
//        list.add("test");
//        list.add(null);
//        System.out.print(list);
//        System.out.println();
        System.out.println(list.getFirst());
//        System.out.println(list.getLast());


    }
}
