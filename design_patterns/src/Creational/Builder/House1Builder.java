package Creational.Builder;


import  Creational.Builder.Builder;
import Creational.Builder.House;
public class House1Builder extends  Builder {

    @Override
    public House build(){
//        house with 1 floor
        this.floor = 1;
        return new House(this);
    }
}
