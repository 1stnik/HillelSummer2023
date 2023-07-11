package lesson_19.io.byteSteram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
    public static void main(String[] args) throws IOException {

        try(
//                FileInputStream fis = new FileInputStream(
//                        "/Users/stepurkoolksandr/HillelProMarkII2022/HillelClassWork/src/com/hillel/lesson_18/io/byteSteram/input.txt"); // -> from
//                FileOutputStream fos = new FileOutputStream(
//                        "/Users/stepurkoolksandr/HillelProMarkII2022/HillelClassWork/src/com/hillel/lesson_18/io/byteSteram/output.txt");
                FileInputStream fis = new FileInputStream("hillelClassworks/src.com.hillel/lesson_19/io/byteSteram/plain.jpg"); // -> from
                FileOutputStream fos = new FileOutputStream("hillelClassworks/src.com.hillel/lesson_19/io/byteSteram/plain_copy.png");
                ) {

            int a;
            while ((a = fis.read()) != -1) {
                fos.write(a);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
