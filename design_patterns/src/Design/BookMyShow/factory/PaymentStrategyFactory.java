package Design.BookMyShow.factory;

import Design.BookMyShow.Strategy.payment.CardPaymentStrategy;
import Design.BookMyShow.Strategy.payment.PaymentStrategy;
import Design.BookMyShow.Strategy.payment.UPIPaymentStrategy;
import Design.BookMyShow.enums.PaymentType;

import static Design.BookMyShow.enums.PaymentType.UPI;

public class PaymentStrategyFactory {

    public static PaymentStrategy getStretagy(PaymentType paymentType) {
        switch (paymentType) {
            case UPI:
                return new UPIPaymentStrategy();
            case CARD:
                return new CardPaymentStrategy();
            default:
                throw new IllegalArgumentException(
                        "Unsupported payment mode: " + paymentType
                );
        }
    }
}
