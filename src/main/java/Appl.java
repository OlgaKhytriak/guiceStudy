import billing.BillingService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import creditcard.CreditCardProcessor;
import transaction.TransactionLog;
import guicemodules.FirstModule;

public class Appl {
// !!!!!!!!!!!!!!!!!!!!!!!!!  TUTORIAL
    //  https://netvl.github.io/guice/users-guide.html
    public static void main(String[] args) {
        /*    Наконец, объединим всё вместе. Для получения экземпляров
        любого из сконфигурированных классов используется класс Injector:
        Модули — это строительный материал для инжектора (injector), класса, который в Guice
        занимается созданием графов объектов. Сначала мы создаём инжектор с
        использованием модуля, а потом мы можем его использовать для получения экземпляра billing.RealBillingService:
         */
        /*
         * Guice.createInjector() берёт набор модулей и возвращает готовый инстанс инжектора.
         * Большинство приложений вызывают этот метод единственный раз, в коде main-метода.
         * Задача инжектора — собрать граф объектов.
         * Мы говорим ему, что хотим получить экземпляр заданного типа, и он автоматически выясняет,
         * что именно нужно создать, разрешает зависимости и связывает всё вместе. Чтобы указать,
         * каким конкретно образом следует разрешать зависимости, инжектор нужно сконфигурировать с помощью привязок.
         */
        Injector injector = Guice.createInjector(new FirstModule());
        /*
         * Теперь, раз у нас есть инжектор, мы можем создавать объекты.
         */
        BillingService billingService = injector.getInstance(BillingService.class);
        /*
        Создав здесь billingService, мы на самом деле создали маленький граф объектов. В этом графе
        содержатся сам биллинговый сервис, а также обработчик кредиток и лог транзакций, от которых сервис зависит.
         */
        CreditCardProcessor creditCardProcessor=injector.getInstance(CreditCardProcessor.class);
        TransactionLog transactionLog=injector.getInstance(TransactionLog.class);
    }
}
