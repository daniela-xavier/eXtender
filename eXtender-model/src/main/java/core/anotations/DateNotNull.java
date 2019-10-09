/**
 * DateNotNull.java
 * Created on 9 de out de 2019
 * 
 *
 */

package core.anotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import core.anotations.validator.DateNotNullValidator;

/**
 * 
 * Description the class  DateNotNull.java 
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateNotNullValidator.class)
public @interface DateNotNull {
	
	String message() default "Data não pode ser vazia!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String value() default "";
    
}
