package br.com.zup.academy.ednelson.casadocodigo.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = UniqueValueValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface UniqueValue {
	
	String message() default "{atributo} existente";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
 
    String value() default "";
    
    Class<?> entidade();

	String atributo();
    
}
