package Design.ATM.States;

import Design.ATM.ATM;
import Design.ATM.TransectionType;

public class SelectOperationState extends State {

    public SelectOperationState(){
        System.out.println("Please select one option: Withdrawal or Credit");
    }

    @Override
    public void chooseOptionState(ATM atm, TransectionType transectionType) {
        switch (transectionType) {

            case WITHDRAWAL:
                atm.changeState(new CashWithdrawalState());
                break;
            case DEPOSIT:
                atm.changeState(new CashDepositState());
                break;
            default: {
                System.out.println("Invalid Option");
                exitState(atm);
            }

        }
    }

    @Override
    public void exitState(ATM atm){
        System.out.println("Exited");
        atm.changeState(new IdleState());
    }
}
