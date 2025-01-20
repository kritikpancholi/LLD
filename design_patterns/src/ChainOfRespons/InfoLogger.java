package ChainOfRespons;

import  ChainOfRespons.Logger;

public class InfoLogger implements  Logger{

    Logger nextLogger ;

    @Override
    public void NextLogger(Logger obj){
        this.nextLogger = obj;
    }
    @Override
    public void HandelRequest(int logLevel){
        if(logLevel == INFO){
            System.out.println("Here in INFO");
        }else{
            nextLogger.HandelRequest(logLevel);
        }
    }

}
