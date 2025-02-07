package Creational.Factory;

public class FactoryDriver {

    public void drive(String os){

        MobileFactory mobileFactory;
        if(os.equals("IOS")){
            mobileFactory = new IosMobileFactory();

        }else if(os.equals("Android")){
            mobileFactory = new AndroidMobileFactory();
        }else {
            mobileFactory = null;
        }

        Mobile mobile = mobileFactory.createMobile();
        mobile.os();
        mobile.company();
    }
}
