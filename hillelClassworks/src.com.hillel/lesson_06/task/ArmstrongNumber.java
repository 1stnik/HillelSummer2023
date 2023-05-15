package lesson_06.task;
// Напишите Java-программу для проверки является ли введенное число - числом Армстронга.
// Прежде всего, нам нужно понять, что такое число Армстронга. Число Армстронга это число,
// значение которого равно сумме цифр, из которых оно состоит, возведенных в степень, равную
// количеству цифр в этом числе. Как пример - число 371:
//    371 = 3*3*3 + 7*7*7 + 1*1*1 = 27 + 343 + 1 = 371
// Если у вас число четырехзначное:
//    8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8 = 4096 + 16 + 0 + 4096 = 8208


public class ArmstrongNumber {
    public static void main(String[] args) {
        int numberCount = 50;
        int count = 0;
        int number = 0;

        while (count < numberCount){
            if (armstrongNumber(number)){
                count++;
                System.out.println(number);
            }
            number++;
        }
    }
    
    private static boolean armstrongNumber(int n){
        String[] split = String.valueOf(n).split("");
        Integer pow = split.length;
        int result = 0;
        for (String s : split){
            result += Math.pow(Integer.parseInt(s), pow);
        }
        return n == result;
    }
}
