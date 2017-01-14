package br.com.caelum.financas.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hibernate.validator.internal.xml.ValidatedByType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy=NumeroEAgenciaValidator.class)
public @interface NumeroEAgencia {

	String message() default
	"{br.com.caelum.financas.validator.NumeroEAgencia.message}";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
}
