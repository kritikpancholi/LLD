package Design.ATM.WithdrawalChain;

import Design.ATM.ATM;

public class TwoThousandNoteProcessor implements WithdrawalProcessor{
    WithdrawalProcessor withdrawalProcessor;
    @Override
    public void  processAmount(ATM atm , int requiredAmount){
        int remangingAmount =  atm.getTwoThousandNoteCount() - requiredAmount%2000;


//        if else
        withdrawalProcessor.processAmount(atm, requiredAmount);
    }

    @Override
    public void nextProcessor(WithdrawalProcessor nextProcessor){
        withdrawalProcessor = nextProcessor;
    }
}
