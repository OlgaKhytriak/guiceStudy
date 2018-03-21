package creditcard;

import model.ChargeResult;
import model.CreditCard;

public interface CreditCardProcessor {
    ChargeResult charge(CreditCard creditCard, int amount);

    CreditCard getCardOfOnlyCharge();

    int getAmountOfOnlyCharge();
}
