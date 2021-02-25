package ac.ttcu.common;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class Log4j {

    /* Get actual class name to be printed on */
    @Autowired
    private static Logger log = Logger.getLogger(Log4j.class.getName());

    public static Logger getLog() {
        return log;
    }
}
