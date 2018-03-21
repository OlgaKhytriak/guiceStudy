package guicemodules;

import billing.BillingService;
import billing.RealBillingService;
import com.google.inject.AbstractModule;
import creditcard.CreditCardProcessor;
import transaction.DatabaseTransactionLog;
import creditcard.PayPalCreditCardProcessor;
import transaction.TransactionLog;

public class FirstModule extends AbstractModule {

    //сопоставить интерфейсы с их реализациями. Это делается в модуле Guice
    /*
    Мы хотим создать billing.RealBillingService с вполне конкретными зависимостями:
    PayPalCreditCardProcessor и DatabaseTransactionLog.
    Guice использует привязки (биндинги), чтобы установить соответствие между типами
    (интерфейсами) и их конкретными реализациями.
    Модуль — это набор привязок, выраженных с помощью вызовов методов, напоминающих простой английский:
    */

    @Override
    protected void configure() {
        /*
         * Здесь мы указываем Guice'у, что где бы он не увидел зависимость на интерфейс TransactionLog,
         * он должен её разрешить с использованием класса DatabaseTransactionLog.
         */
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        /*
         * Аналогично, эта привязка указывает, что если интерфейс CreditCardProcessor используется
         * где-либо в качестве зависимости, Guice должен будет использовать класс PayPalCreditCardProcessor.
         */
        bind(CreditCardProcessor.class).to(PayPalCreditCardProcessor.class);
        bind(BillingService.class).to(RealBillingService.class);
    }
/*
Привязки создаются с помощью модулей.
Для этого проще всего унаследовать абстрактный класс AbstractModule
и переопределить его метод configure(). В теле этого метода нужно вызывать метод bind()
чтобы описать каждую привязку.
 */

}
