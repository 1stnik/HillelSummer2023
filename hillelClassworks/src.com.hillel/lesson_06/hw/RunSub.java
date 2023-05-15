package lesson_06.hw;

public class RunSub {
    public static void main(String[] args) {
        Sub[] subs = SubGen.generateSubArray();
        for(Sub s : subs){
            System.out.println(s);
        }
    }
}
