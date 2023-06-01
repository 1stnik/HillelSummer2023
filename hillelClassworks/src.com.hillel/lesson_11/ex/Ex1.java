package lesson_11.ex;

public class Ex1 {
    public static void main(String[] args) {
        long a = 0;
        Long b = null; // --> long Long.longValue()

        if (b == a) {
            System.out.println("==");
        } else {
            System.out.println("!=");
        }
    }
}
