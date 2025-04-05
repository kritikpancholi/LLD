package Design.ATM.States;
import Design.ATM.ATM;
import Design.ATM.Card;

public class IdleState extends State{

    public IdleState(){
        System.out.println("System is idle");
    }

    @Override
    public void insertCard(ATM atm , Card card){
        atm.changeState(new HasCardState());
    }

}
