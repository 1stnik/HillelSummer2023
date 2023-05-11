package lesson_05.task;

public class LuckyNumbers {

    public boolean calculateLuckyNumber(String value) {
        String[] split = value.split("");
        if (split.length % 2 != 0) {
            return false;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < split.length / 2; i++) {
            left  += Integer.parseInt(split[i]);
            right += Integer.parseInt(split[split.length - 1 - i]);
        }
        return left == right;
    }
    public static void main(String[] args) {
        LuckyNumbers ln = new LuckyNumbers();
        System.out.println(ln.calculateLuckyNumber("564195"));
    }
}
