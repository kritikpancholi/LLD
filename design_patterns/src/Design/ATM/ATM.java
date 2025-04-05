package Design.ATM;
import Design.ATM.States.IdleState;
import  Design.ATM.States.State;

public class ATM {

    State currentState;
    int twoThousandNoteCount ;

    public ATM(int twoThousandNoteCount){
        this.twoThousandNoteCount= twoThousandNoteCount;
        this.currentState = new IdleState();
    }
    public void changeState(State newState){
        currentState = newState;
    }
    public int getTwoThousandNoteCount(){
        return twoThousandNoteCount;
    }
}
