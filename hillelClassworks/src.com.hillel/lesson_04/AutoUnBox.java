package lesson_04;

public class AutoUnBox {
    public static void main(String[] args) {
        int a = 10;
        Integer aI = a;

        System.out.println(aI);

        int iP = aI;

        System.out.println(iP);

        long l = aI;
    }
}
