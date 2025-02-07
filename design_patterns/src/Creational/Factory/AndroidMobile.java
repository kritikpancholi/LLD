package Creational.Factory;

public class AndroidMobile implements  Mobile{

    @Override
    public void os(){
        System.out.println("Android mobile");
    }

    @Override
    public void company(){
        System.out.println("Samsung");
    }

}
