package Creational.Factory;

public class IosMobile implements Mobile {

    @Override
    public void os(){
        System.out.println("IOS mobile");
    }

    @Override
    public void company(){
        System.out.println("Apple");
    }
}
