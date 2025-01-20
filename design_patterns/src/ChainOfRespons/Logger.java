package ChainOfRespons;

public interface Logger {
    static int INFO = 1;
    static int DEBUG = 2;
    static int ERROR = 3;

    Logger nextLogProccessor ;

    Logger(Logger logger){
            logObj = logger
    }

    void HandelRequest();



}
