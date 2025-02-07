package Creational.Factory;

public class IosMobileFactory extends  MobileFactory{

    @Override
    Mobile createMobile(){
        return new IosMobile();
    }
}
