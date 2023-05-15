package lesson_06.task;

public class PusUp {
    /*
    Человек подтягивается, делает подходы лесенкой начиная с 1 раза
    - подсчитать сколько он всего подтянеться за N подходов, N задано с клавиатуры
    N = 4 -> 1 + 2 + 3 + 4 = 10

    - вывести общее время выполнения упражнения (10:45)
    каждое подтягивание занимает 5с, первый перерыв между подходами 60с,
    каждый следующий перерыв на 20% больше предыдущего.
     */
    public static void main(String[] args) throws InterruptedException {
        int attempt = 2;
        int pushupTime = 5;
        int rest = 60;
        double restCoef = 1.2;
        int totalTime = 0;
        int totalPushup = 0;

        for (int i = 1; i <= attempt; i++){
            System.out.println("attempt #" + i);
            for (int j = 0; j < i; j++){
                totalTime += pushupTime;
//                Thread.sleep(500);
                System.out.print("#");
            }
            if (i < attempt) {
                rest = (int) (rest * (i * restCoef));
                totalTime += rest;
            }
            System.out.println();
            totalPushup += i;
        }
        System.out.println(pushupTime);
        System.out.println("total pushup # " + totalPushup);
        System.out.println("total time -> " + totalTime / 60 + "min " + totalTime % 60 + " s");


    }
}
