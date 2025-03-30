package Design.Splitwise.SplitStrategy;

import Design.Splitwise.Expense;
import Design.Splitwise.Split;

public class ExpenseEqualSplit implements ExpenseSplit {

    @Override
    public void makeSplit(Expense expense) {
        int splitSize = expense.lentBy.size() + 1;
        float splitAmount = expense.amount/splitSize;
        for(int i = 0;i<expense.lentBy.size() ;i++){
            expense.addSplitDetail(new Split(expense.lentBy.get(i),splitAmount));
        }
    }
}
