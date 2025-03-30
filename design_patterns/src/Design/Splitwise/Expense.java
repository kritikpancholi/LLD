package Design.Splitwise;

import java.util.ArrayList;
import java.util.List;

public class Expense {

    public int id;
    public float amount;
    public User paidBy;
    public List<User> lentBy;
    public SplitType splitType;
    public List<Split> splitDetail ;
    public Expense(int id, float amount, User paidBy, List<User> lentBy, SplitType splitType){
        this.id = id;
        this.amount = amount;
        this.paidBy = paidBy;
        this.lentBy = lentBy;
        this.splitType = splitType;
        this.splitDetail = new ArrayList<>();
    }

    public void addSplitDetail(Split userSplit){
        splitDetail.add(userSplit);
    }

}
