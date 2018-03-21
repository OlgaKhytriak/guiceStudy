package guicemodules;

import com.google.inject.AbstractModule;
import transaction.DatabaseTransactionLog;
import transaction.MySqlDatabaseTransactionLog;
import transaction.TransactionLog;

public class LinkedBindsModule extends AbstractModule {
    /*Компоновочные (или обычные) привязки связывают тип с его реализацией.
     Здесь интерфейс TransactionLog связывется со своей реализацией DatabaseTransactionLog:
     */
    //@Override
    protected void configure1() {// !!! метод завжди наз configure
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
    }
/*
Теперь, когда мы вызываем Injector.getInstance(TransactionLog.class), либо если инжектор сам обнаружит в
графе объектов зависимость от TransactionLog, то он автоматически будет использовать DatabaseTransactionLog.
В компоновочных привязках связь может идти от типа к любому из подтипов, например, от интерфейса к его реализации
или от класса к его наследнику.
 */

    @Override
    protected void configure() {
        /*
        когда инжектору понадобится реализация интерфейса TransactionLog,
        будет использован класс MySqlDatabaseTransactionLog.
         */
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(DatabaseTransactionLog.class).to(MySqlDatabaseTransactionLog.class);
    }
}
