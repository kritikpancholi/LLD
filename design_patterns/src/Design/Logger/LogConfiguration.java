package Design.Logger;

import Design.Logger.Appender.LogAppender;
import Design.Logger.LogHandler.DebugHandler;
import Design.Logger.LogHandler.ErrorHandler;
import Design.Logger.LogHandler.InfoHandler;
import Design.Logger.LogHandler.LogHandler;

public class LogConfiguration {

    private static LogHandler debug = new DebugHandler();
    private static LogHandler info = new InfoHandler();
    private static LogHandler error = new ErrorHandler();


    public static LogHandler build(){
        info.setNextHandler(debug);
        debug.setNextHandler(error);

        return info;
    }

    public static void setAppender(LogLevel logLevel , LogAppender logAppender){
        switch (logLevel){
            case INFO -> info.setLogAppender(logAppender);
            case DEBUG -> debug.setLogAppender(logAppender);
            case ERROR -> error.setLogAppender(logAppender);
        }
    }

}
