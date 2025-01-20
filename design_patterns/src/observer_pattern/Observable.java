package observer_pattern;

import java.util.List;
import observer_pattern.Observer;

public interface Observable {

//    List<Observer> ObserverList;


    void AddObserver(Observer obj);
    void Notify();
    void RemoveObserver(Observer obj);

}
