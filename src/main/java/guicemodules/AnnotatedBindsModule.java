package guicemodules;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import creditcard.*;
import guicemodules.annotation.PayPal;

public class AnnotatedBindsModule extends AbstractModule {
    /*
    Иногда требуется создать несколько привязок одного и того же типа.
    Например, одновременно в программе может потребоваться использовать
    обработчик кредитных кард PayPal и обработчик Google Checkout.
    Для этого используются привязочные аннотации.
    Аннотация и тип вместе определяют привязку единственным образом. Такая пара называется ключом.
     */

    protected void configure() {
        // -------------------------------анотація @PayPal
        bind(CreditCardProcessor.class).annotatedWith(PayPal.class).to(PayPalCreditCardProcessor.class);

        //-------------------------------анотація @Named
        bind(CreditCardProcessor.class).annotatedWith(Names.named("Checkout")).to(CheckoutCreditCardProcessor.class);

        //-------------------------------Экземплярные привязки
    /*
    Тип можно привязать к конкретному объекту, принадлежащему этому типу. Это полезно только в том случае,
    когда требуется привязывать объекты без собственных зависимостей, такие, как объекты-значения.
    */
        bind(String.class).annotatedWith(Names.named("JDBC URL")).toInstance("jdbc:mysql://localhost/pizza");
        bind(Integer.class).annotatedWith(Names.named("login timeout seconds")).toInstance(10);

        //---------------------------------Binding annotations with attributes (Привязочные аннотации с атрибутами)
    /*
    Guice поддерживает создание и использование привязочных аннотаций,
    с которыми связаны конкретные значения (как у @Named).
    В тех редких случаях, когда это может понадобиться, нужно сделать следующее:
    1. создать интерфейс аннотации;
    2. создать класс, “реализующий” интерфейс аннотации; при определении методов hashCode() и equals() следует пользоваться документацией;
    3. передать экземпляр этого класса в метод annotatedWith() при объявлении привязки.
     */
    }
}
