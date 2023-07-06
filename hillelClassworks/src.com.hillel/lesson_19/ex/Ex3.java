package lesson_19.ex;

public class Ex3 {
    public static void main(String[] args) {
        int x = 7;

//        boolean res = x++ == 7 && ++x == 9 || x++ ==  9; // true && true || true
        boolean res = x++ == 7 & ++x == 9 | x++ == 9;

        System.out.println("x = " + x);
        System.out.println("res = " + res);
    }
}
