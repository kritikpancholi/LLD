package Design.Splitwise;

import Design.Splitwise.SplitStrategy.ExpenseEqualSplit;
import Design.Splitwise.SplitStrategy.ExpensePercentageSplit;
import Design.Splitwise.SplitStrategy.ExpenseSplit;
import Design.Splitwise.SplitStrategy.ExpenseUnequalSplit;

public class ExpenseSplitFactory {
    public ExpenseSplit createExpenseSplit(SplitType splitType){
        if(splitType == SplitType.EQUAL){
            return new ExpenseEqualSplit();
        }else if(
                splitType == SplitType.UNEQUAL
        ){
            return new ExpenseUnequalSplit();
        }else {
            return new ExpensePercentageSplit();
        }
    }
}
