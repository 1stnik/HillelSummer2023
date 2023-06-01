package lesson_11.exception;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;
import lesson_10.CharC.Text;

public class CloseExample {
    public static void main(String[] args) throws SQLException {

        try (Test text = new Test();) {
            text.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Test  implements Closeable{
    @Override
    public void close() throws IOException {
        System.out.println("run method : close()");
    }

    public void run() throws SQLException {
        System.out.println("run method : run()");
        throw new BussinesException("class run");
    }
}
