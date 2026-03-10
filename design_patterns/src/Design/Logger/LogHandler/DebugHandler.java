package Design.Logger.LogHandler;

import Design.Logger.LogLevel;
import Design.Logger.LogMessage;

public class DebugHandler extends LogHandler{
    @Override
    public boolean canHandle(LogMessage logMessage) {
        return logMessage.getLevel().equals(LogLevel.DEBUG);
    }
}
