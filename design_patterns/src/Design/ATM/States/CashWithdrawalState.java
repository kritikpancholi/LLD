package Design.ATM.States;

import Design.ATM.ATM;

public class CashWithdrawalState extends  State{

    public CashWithdrawalState(){
        System.out.println("Cash withdrawal state");
    }

    @Override
    public void cashWithdrawalState(ATM atm, int amount){
//            call chain of processor for amount if fail exit
    }

}
