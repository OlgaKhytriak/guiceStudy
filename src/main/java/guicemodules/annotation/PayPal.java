package guicemodules.annotation;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/*
@BindingAnnotation указывает Guice, что это привязочная аннотация;
если один и тот же идентификатор помечен двумя и более привязочными аннотациями, то Guice выкинет ошибку;
 */
@BindingAnnotation
@Target({FIELD, PARAMETER, METHOD})
@Retention(RUNTIME)
public @interface PayPal {
}
