package Design.Splitwise;

import java.util.HashMap;

public class User {

    public int id;
    public String email;
    public String name;
    public UserExpenseBook userExpenseBook;

    public User(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;


        this.userExpenseBook = new UserExpenseBook();
    }

    public int getId() {
        return id;
    }
    public void printBook(){
        System.out.println("User -> "+id +" lent users :- ");
        userExpenseBook.printBook();
    }
}
