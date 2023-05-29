package lesson_10;

public class SB {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Test SB");
//        StringBuilder sb1 = "Test";

        System.out.println(sb);

        String test = "Test";

        sb.append(" str");

        System.out.println(sb);

        String str = "ssss";

        str = str + "sss";

        System.out.println(sb.reverse());

        System.out.println(sb.charAt(0));
        sb.setCharAt(0, 'R');
        System.out.println(sb);
        System.out.println(sb.substring(1, 4));

        String s = sb.toString();
    }
}
