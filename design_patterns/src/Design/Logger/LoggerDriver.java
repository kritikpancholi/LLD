package Design.Logger;

import Design.Logger.Appender.ConsoleAppender;
import Design.Logger.Appender.FileAppender;
import Design.Logger.Appender.LogAppender;
import Design.Logger.LogFormatter.PlainTextFormatter;

public class LoggerDriver {

    public void drive(){

        Logger logger = Logger.getInstance();
        LogConfiguration.setAppender(LogLevel.INFO, new ConsoleAppender( new PlainTextFormatter()));
        LogConfiguration.setAppender(LogLevel.DEBUG, new ConsoleAppender(new PlainTextFormatter()));
        LogConfiguration.setAppender(LogLevel.ERROR, new ConsoleAppender(new PlainTextFormatter()));
        LogConfiguration.setAppender(LogLevel.ERROR, new FileAppender(new PlainTextFormatter()));
        logger.info("This is ");
        logger.error("Error = ");
        
    }

}
