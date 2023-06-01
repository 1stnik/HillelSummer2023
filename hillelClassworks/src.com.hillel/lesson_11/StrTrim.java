package lesson_11;

public class StrTrim {

    public static void main(String[] args) {
        String str = "   aaa    ";
        System.out.println("<" + str + ">");

        String strTrim = str.trim();
        System.out.println("<" + strTrim + ">");
    }
}
