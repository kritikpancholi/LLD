package Creational.Builder;

public class Director {
    Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }

    public House createHouse(){
        if (builder instanceof  House1Builder){
            return builder.buildDoor("1 door ").build();
        }else if(builder instanceof  House2Builder){
            return builder.buildDoor("2 door ").buildWindows("2 window").build();
        }
        return null;
    }

}
