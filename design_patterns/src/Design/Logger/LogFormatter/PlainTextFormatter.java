package Design.Logger.LogFormatter;

import Design.Logger.LogMessage;

public class PlainTextFormatter implements LogFormatter{
    @Override
    public String formate(LogMessage message) {
        return String.format("PlainTextFormatter + "+message.getLevel()+ " " + message.getMessage());
    }
}