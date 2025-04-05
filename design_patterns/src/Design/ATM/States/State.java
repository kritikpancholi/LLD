package Design.ATM.States;

import Design.ATM.ATM;
import Design.ATM.Card;
import Design.ATM.TransectionType;

public abstract class State {

    public void insertCard(ATM atm, Card card){
        System.out.println("This is insertCard");
    }
    public void validateCardState(ATM atm, Card card, int pin, String accountNumber){
        System.out.println("This is validateCard");
    }
    public void chooseOptionState(ATM atm , TransectionType transectionType){
        System.out.println("This is choose Option state");
    }
    public void performOptionState(){
        System.out.println("This is perform option state");
    }
    public void exitState(ATM atm){
        System.out.println("This is exit state");
    }
    public void cashWithdrawalState(ATM atm, int amount){
        System.out.println("This is cashWithdrawalState");
    }

}
