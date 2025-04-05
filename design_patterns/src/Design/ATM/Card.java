package Design.ATM;

public class Card {
    String cardNumber;
    int pin;

    public Card(String cardNumber, int pin){
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
