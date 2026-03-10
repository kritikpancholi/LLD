package Design.Logger.LogHandler;

import Design.Logger.Appender.LogAppender;
import Design.Logger.LogLevel;
import Design.Logger.LogMessage;

public class InfoHandler extends LogHandler {

    @Override
    public boolean canHandle(LogMessage logMessage) {
        return logMessage.getLevel().equals(LogLevel.INFO);
    }
}
