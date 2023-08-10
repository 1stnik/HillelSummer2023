import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Run {

    private static final Logger logger = LoggerFactory.getLogger("logger.debug");

    public static void main(String[] args) {
        logger.debug("application start ...");
        System.out.println("Hello word ...");
        log.debug("Hello world ... info");
        logger.debug("Hello world ... info");
        logger.debug("application finish ...");
        logger.debug("------------------------------------");

    }
}
