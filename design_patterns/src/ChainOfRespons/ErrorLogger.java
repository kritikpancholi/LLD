package ChainOfRespons;

import  ChainOfRespons.Logger;

public class ErrorLogger implements  Logger{
    Logger nextLogger ;

    @Override
    public void NextLogger(Logger obj){
        this.nextLogger = obj;
    }
    @Override
    public void HandelRequest(int logLevel){
        if(logLevel == ERROR){
            System.out.println("Here in ERROR");
        }else{
            nextLogger.HandelRequest(logLevel);
        }
    }
}
