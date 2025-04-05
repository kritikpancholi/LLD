package Design.ATM.WithdrawalChain;

import Design.ATM.ATM;

public interface WithdrawalProcessor {

    public void processAmount(ATM atm , int requiredAmount);

    public void nextProcessor(WithdrawalProcessor withdrawalProcessor);


}
