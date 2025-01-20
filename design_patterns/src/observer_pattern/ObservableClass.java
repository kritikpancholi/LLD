package observer_pattern;

import observer_pattern.Observer;
import observer_pattern.Observable;

import java.util.ArrayList;
import java.util.List;

public class ObservableClass  implements  Observable{

    List<Observer> ObserverList;

    public ObservableClass(){
        this.ObserverList = new ArrayList<>();
    }

    @Override
    public void AddObserver(Observer obj){
        System.out.println("here");
        ObserverList.add(obj);
    }
    @Override
    public void Notify(){
//        ObserverList.forEach();
        for (Observer observer : ObserverList) {
            observer.Update("This is Update");
        }
    }
    @Override
    public void RemoveObserver(Observer obj){
        ObserverList.remove(obj);
    }



}
