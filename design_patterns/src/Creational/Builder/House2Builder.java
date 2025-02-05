package Creational.Builder;

public class House2Builder extends  Builder  {

    @Override
    public House build(){
//        house with 2 floor
        this.floor = 2;
        return new House(this);
    }
}
