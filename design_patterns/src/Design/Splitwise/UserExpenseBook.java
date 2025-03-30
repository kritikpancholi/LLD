package Design.Splitwise;

import java.util.Map;

public class UserExpenseBook {


    Map<Integer,Float> userOwe;

    public void addUserLent(User user , float amount){
        float currentAmount  = 0;
        if(userOwe.containsKey(user.getId())){
            currentAmount = userOwe.get(user.getId()) + amount;
            userOwe.replace(user.getId(),currentAmount);
//            float newAmount = currentAmount+ amount
        }else {
            currentAmount  = amount;
            userOwe.put(user.getId(),currentAmount);
        }
    }

    public  void printBook(){

        userOwe.forEach((key,val) -> System.out.println("user id -> "+ key + " amount -> "+ val ) );
    }
}
