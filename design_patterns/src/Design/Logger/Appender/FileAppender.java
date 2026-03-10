package Design.Logger.Appender;

import Design.Logger.LogFormatter.LogFormatter;
import Design.Logger.LogMessage;

public class FileAppender implements LogAppender{

    private LogFormatter logFormatter;

    public FileAppender(LogFormatter logFormatter){
        this.logFormatter = logFormatter;
    }

    @Override
    public void appendLog(LogMessage message)
    {
        System.out.println("File appender" + logFormatter.formate(message));
    }
}
