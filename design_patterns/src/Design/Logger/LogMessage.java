package Design.Logger;

public class LogMessage {
    public String message;
    public LogLevel level;

    LogMessage(String message, LogLevel level){
        this.level = level;
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public LogLevel getLevel(){
        return level;
    }
}
