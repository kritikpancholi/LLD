package Design.Logger.Appender;

import Design.Logger.LogFormatter.LogFormatter;
import Design.Logger.LogMessage;

public interface LogAppender {
    void appendLog(LogMessage message);

}
