package ChainOfRespons;

public class ChainOfResponsDriver {
    public void RunDriver(){
        Logger InfoLog = new InfoLogger();
        Logger DebugLog = new DebugLogger();
        Logger ErrorLog = new ErrorLogger();

        InfoLog.NextLogger(DebugLog);
        DebugLog.NextLogger(ErrorLog);

        InfoLog.HandelRequest(2);
        InfoLog.HandelRequest(3);

    }
}
