import ChainOfRespons.ChainOfResponsDriver;
import Design.Logger.LoggerDriver;
import observer_pattern.Driver;
import Design.Cache.CacheDriver;
import Creational.Builder.BuilderDriver;
import Creational.Factory.FactoryDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//import Me.*;



public class Main {
    public static void main(String[] args) {
//   for observer
//    Driver obj = new Driver();

//        ChainOfResponsDriver obj = new ChainOfResponsDriver();
//        obj.RunDriver();

//        CacheDriver cacheDriver = new CacheDriver();

//        BuilderDriver builderDriver = new BuilderDriver();
//        builderDriver.build();


//        FactoryDriver  factoryDriver = new FactoryDriver();
//
//        factoryDriver.drive("Android");
//        factoryDriver.drive("IOS");
        LoggerDriver loggerDriver = new LoggerDriver();
        loggerDriver.drive();


    }
}