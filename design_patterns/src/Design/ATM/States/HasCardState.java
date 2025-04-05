package Design.ATM.States;

import Design.ATM.ATM;
import Design.ATM.Card;

public class HasCardState extends State{

    public HasCardState(){
        System.out.println("enter your card pin number");
    }

    @Override
    public void validateCardState(ATM atm, Card card, int pin, String accountNumber){
        if(pin == card.getPin() && accountNumber.equals(card.getCardNumber())){
            System.out.println("Pin is valid");
            atm.changeState(new SelectOperationState());
        }else {
            exitState(atm);
        }
    }

    @Override
    public void exitState(ATM atm){
        System.out.println("card return");
        atm.changeState(new IdleState());
    }
}
