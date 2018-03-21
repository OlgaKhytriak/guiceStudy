package creditcard;

import creditcard.CreditCardProcessor;
import model.ChargeResult;
import model.CreditCard;

public class PayPalCreditCardProcessor implements CreditCardProcessor {
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
