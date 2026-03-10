package Design.Logger;

import Design.Logger.LogHandler.LogHandler;

public class Logger {
    private static Logger logger;

    private final LogHandler logHandler;

    private Logger(){
        logHandler = LogConfiguration.build();
    };

    public static Logger getInstance(){
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    private void log(LogMessage logMessage){
        logHandler.handleLog(logMessage);
    }

    public void info(String message){
        log(new LogMessage(message, LogLevel.INFO));
    }
    public void debug(String message){
        log(new LogMessage(message, LogLevel.DEBUG));
    }
    public void error(String message){
        log(new LogMessage(message, LogLevel.ERROR));
    }

}
