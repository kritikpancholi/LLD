package observer_pattern;


public class PhoneObserver implements Observer {

    public void Update(String s){
        System.out.println("This is phone update = "+ s);
    }
}
