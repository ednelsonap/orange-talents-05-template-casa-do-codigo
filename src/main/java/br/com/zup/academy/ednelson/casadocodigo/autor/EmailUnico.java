package br.com.zup.academy.ednelson.casadocodigo.autor;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = EmailUnicoValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface EmailUnico {

	String message() default "Email já cadastrado";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
 
    String value() default "";
}
