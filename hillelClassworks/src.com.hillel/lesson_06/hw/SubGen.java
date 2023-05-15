package lesson_06.hw;

public class SubGen {

    public static Sub[] generateSubArray(){
        Sub[] array = new Sub[3];
        array[0] = new Sub(1, "user1", "234356789");
        array[1] = new Sub(2, "user3", "546755656");
        array[2] = new Sub(3, "user3", "546874563");

        return array;
    }
}
