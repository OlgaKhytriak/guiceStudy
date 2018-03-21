package creditcard;

import model.ChargeResult;
import model.CreditCard;

public class CheckoutCreditCardProcessor implements CreditCardProcessor{
    public ChargeResult charge(CreditCard creditCard, int amount) {
        return null;
    }

    public CreditCard getCardOfOnlyCharge() {
        return null;
    }

    public int getAmountOfOnlyCharge() {
        return 0;
    }
}
