package Design.Logger.Appender;

import Design.Logger.LogFormatter.LogFormatter;
import Design.Logger.LogMessage;

public class ConsoleAppender implements LogAppender{

    private LogFormatter logFormatter;

    public ConsoleAppender(LogFormatter logFormatter){
        this.logFormatter = logFormatter;
    }

    @Override
    public void appendLog(LogMessage message) {
        System.out.println("Console appender " + logFormatter.formate(message));
    }
}
