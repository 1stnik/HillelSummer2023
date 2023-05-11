package lesson_05.ex;

public class Ex1 {
    static int a = 1111;

    static {
        System.out.println("static");
        a = a-- - --a; //1111 - 1109 -> 2
    }

    {
        System.out.println("non static");
        a = a++ + ++a; // 2 + 4 -> 6
    }

    public static void main(String[] args) {
        System.out.println(a);
        Ex1 ex1 = new Ex1();
        System.out.println(a);
    }
}
