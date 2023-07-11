package lesson_19;

import java.io.File;

public class GetAbsPath {
    public static void main(String[] args) {
        String absolutePath = new File(".").getAbsolutePath();
        System.out.println(absolutePath);
    }
}
