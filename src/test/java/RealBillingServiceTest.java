import billing.RealBillingService;
import junit.framework.TestCase;
import model.CreditCard;
import model.PizzaOrder;
import model.Receipt;
import creditcard.CreditCardProcessor;
import creditcard.FakeCreditCardProcessor;
import transaction.InMemoryTransactionLog;
import transaction.TransactionLog;

public class RealBillingServiceTest extends TestCase {
    private final PizzaOrder order = new PizzaOrder(100);
    private final CreditCard creditCard = new CreditCard("1234", 11, 2010);

    private final TransactionLog transactionLog = new InMemoryTransactionLog();
    private final CreditCardProcessor creditCardProcessor = new FakeCreditCardProcessor();


    public void testSuccessfulCharge() {
        RealBillingService billingService
                = new RealBillingService(creditCardProcessor, transactionLog);
        Receipt receipt = billingService.chargeOrder(order, creditCard);

        assertTrue(receipt.hasSuccessfulCharge());
        assertEquals(100, receipt.getAmountOfCharge());
        assertEquals(creditCard, creditCardProcessor.getCardOfOnlyCharge());
        assertEquals(100, creditCardProcessor.getAmountOfOnlyCharge());
        assertTrue(transactionLog.wasSuccessLogged());
    }
}
