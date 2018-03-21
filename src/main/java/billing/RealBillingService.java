package billing;

import billing.BillingService;
import com.google.inject.Inject;
import creditcard.CreditCardProcessor;
import guicemodules.annotation.PayPal;
import model.*;
import transaction.TransactionLog;

public class RealBillingService implements BillingService {
    private final CreditCardProcessor processor;
    private final TransactionLog transactionLog;
    /*добавим аннотацию @Inject к конструктору , чтобы Guice знал,
    что нужно использовать именно его. Guice, пользуясь сигнатурой такого конструктора,
    распознает типы параметров и создаст необходимые для них объекты автоматически.
    */
    @Inject
    public RealBillingService(CreditCardProcessor processor,
                              TransactionLog transactionLog) {
        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    /*----------------------- Конструктори для AnnotatedBindsModule
    // Чтобы объявить зависимость на аннотированную привязку,
    // достаточно просто применить аннотацию на внедряемый параметр:
    -------------------------------анотація @PayPal
    @Inject
    public RealBillingService(@PayPal CreditCardProcessor processor, TransactionLog transactionLog) {
        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    -------------------------------анотація @Named
    // аннотация @Named принимает строку в качестве параметра:
    @Inject
     public RealBillingService(@Named("Checkout") CreditCardProcessor processor, TransactionLog transactionLog){
        this.processor = processor;
        this.transactionLog = transactionLog;
    }
------------------------------------------------------------------------*/



    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        //CreditCardProcessor processor = new PayPalCreditCardProcessor();
        //TransactionLog transactionLog = new DatabaseTransactionLog();

        ChargeResult result = processor.charge(creditCard, order.getAmount());
        transactionLog.logChargeResult(result);

        return result.wasSuccessful()
                ? Receipt.forSuccessfulCharge(order.getAmount())
                : Receipt.forDeclinedCharge(result.getDeclineMessage());
    }


}
