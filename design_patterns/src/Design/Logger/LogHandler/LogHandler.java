package Design.Logger.LogHandler;

import Design.Logger.Appender.LogAppender;
import Design.Logger.LogLevel;
import Design.Logger.LogMessage;

import java.util.ArrayList;

public abstract class LogHandler {

        LogHandler nextHandler;
        ArrayList<LogAppender> logAppender = new ArrayList<>();

        public void setLogAppender(LogAppender logAppender){
                this.logAppender.add(logAppender);
        }

        public void setNextHandler(LogHandler nextHandler){
                this.nextHandler = nextHandler;
        }

        private void notifyAppender(LogMessage logMessage){
            for (LogAppender appender : logAppender) {
                appender.appendLog(logMessage);
            }
        }

        public  void handleLog(LogMessage logMessage){
                if(canHandle(logMessage)){
                        notifyAppender(logMessage);
                }else if(nextHandler !=  null){
                        nextHandler.handleLog(logMessage);
                }
        }

        public abstract boolean canHandle(LogMessage logMessage);


}
