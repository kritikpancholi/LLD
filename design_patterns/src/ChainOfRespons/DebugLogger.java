package ChainOfRespons;
import  ChainOfRespons.Logger;

public class DebugLogger implements  Logger{

    Logger nextLogger ;

    @Override
    public void NextLogger(Logger obj){
        this.nextLogger = obj;
    }
    @Override
    public void HandelRequest(int logLevel){
        if(logLevel == DEBUG){
            System.out.println("Here in DEBUG");
        }else{
            nextLogger.HandelRequest(logLevel);
        }
    }

}
