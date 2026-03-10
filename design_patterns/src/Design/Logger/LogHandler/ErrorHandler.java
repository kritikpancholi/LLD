package Design.Logger.LogHandler;

import Design.Logger.LogLevel;
import Design.Logger.LogMessage;

public class ErrorHandler extends LogHandler{
    @Override
    public boolean canHandle(LogMessage logMessage) {
        return logMessage.getLevel().equals(LogLevel.ERROR);
    }
}
