package lesson_05.task;

// Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
public class NumGrow {
    public static void main(String[] args) {
        int[] mass = {1, 25, 123, 12345}; // -> 12345

        for (int i : mass) {
            boolean flag = false;
            String tmp = String.valueOf(i);
            if (tmp.length() < 2) continue;
            String[] split = tmp.split("");
            for (int j = 1; j < split.length; j++) {
                System.out.println(split[j]);
                if (Integer.parseInt(split[j]) - Integer.parseInt(split[j - 1]) == 1) {
                    flag = true;
                } else {
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
//                break;
            }
        }
    }
}
