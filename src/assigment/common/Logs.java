package assigment.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class Logs {

    static Logger logger = Logger.getLogger(Logs.class);
    static 
    {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormatDate = new SimpleDateFormat("dd_MM_yyyy");
        Date date = new Date();
        String formattedDate = dateFormatDate.format(date);
        PatternLayout layout = new PatternLayout();
        String conversionPattern = "%-7p %d [%t] %c %x - %m%n";
        layout.setConversionPattern(conversionPattern);

        FileAppender fileAppender = new FileAppender();
        fileAppender.setFile(OperationsOnFiles.LOG_PATH + "Error_log_" + formattedDate + ".log");
        fileAppender.setLayout(layout);
        fileAppender.activateOptions();

        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.DEBUG);
        rootLogger.addAppender(fileAppender);
    }

    public static void printLogs(String message) {
        
        logger.error(message);
    }
}
