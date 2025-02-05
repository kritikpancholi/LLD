import ChainOfRespons.ChainOfResponsDriver;
import observer_pattern.Driver;
import Design.Cache.CacheDriver;
import Creational.Builder.BuilderDriver;

public class Main {
    public static void main(String[] args) {
//   for observer
//    Driver obj = new Driver();

//        ChainOfResponsDriver obj = new ChainOfResponsDriver();
//        obj.RunDriver();

//        CacheDriver cacheDriver = new CacheDriver();

        BuilderDriver builderDriver = new BuilderDriver();
        builderDriver.build();


    }
}