package lesson_19.io.FileStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamm {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream =
                new FileOutputStream("hillelClassworks/src.com.hillel/lesson_19/io/FileStream/output.txt", false);

        outputStream.write("override text from java app\n".getBytes(StandardCharsets.UTF_8));
    }
}
