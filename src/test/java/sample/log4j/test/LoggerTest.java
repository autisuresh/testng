package sample.log4j.test;

import org.apache.logging.log4j.*;
import org.testng.annotations.Test;

public class LoggerTest {
    public static Logger log = LogManager.getLogger(LoggerTest.class.getName());

    @Test
    public void logTest_1() {
        log.debug("debug");
        log.error("error");
        log.fatal("fatal");
        log.info("info");
    }
}
