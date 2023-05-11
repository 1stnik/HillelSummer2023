package lesson_05.task;


public class WhiteSpaceRemover {
    // Напишите Java-программу для удаления всех пробелов из строки без использования replace().
    public static void main(String[] args) {
        String str = "   Hello World Напишите Java-программу для удаления всех " +
                "пробелов из строки без использования replace().   ";

        System.out.println(removeWhitespases(str));
    }

    private static String removeWhitespases(String str) {
        String[] s = str.split(" ");
        String tmp = "";
        for (String s1 : s) {
            tmp = tmp.concat(s1);
        }
        return tmp;
    }
}
