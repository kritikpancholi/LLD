package observer_pattern;

import observer_pattern.*;

public class Driver {

    Observable obj = new ObservableClass();
    Observer phoneObj = new PhoneObserver();

    public Driver(){
        System.out.println("here - 1");
        this.obj = new ObservableClass();
        System.out.println("here - 2");
        obj.AddObserver(phoneObj);
        System.out.println("here - 3");
        obj.Notify();
        System.out.println("here - 4");

    }

}
