package billing;

import model.CreditCard;
import model.PizzaOrder;
import model.Receipt;

public interface BillingService {
    /**
     * Совершает попытку списания суммы заказа с кредитной карты. Записываются
     * как успешные, так и неуспешные транзакции.
     *
     * @return возвращает чек транзации. Если списание было успешно,
     *         чек содержит подтверждение. В противном случае чек содержит
     *         запись причины отказа.
     */
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
