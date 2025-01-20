package ChainOfRespons;

public interface Logger {
    static int INFO = 1;
    static int DEBUG = 2;
    static int ERROR = 3;

    void HandelRequest(int logLevel);

    void NextLogger(Logger obj);

}
