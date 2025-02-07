package Creational.Factory;

public class AndroidMobileFactory extends MobileFactory{

    @Override
    Mobile createMobile(){
        return new AndroidMobile();
    }

}
