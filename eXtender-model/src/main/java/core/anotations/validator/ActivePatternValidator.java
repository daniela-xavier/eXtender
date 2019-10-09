/**
 * ActivePatternValidator.java
 * Created on 9 de out de 2019
 * 
 *
 */

package core.anotations.validator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import core.anotations.ActivePattern;

/**
 * 
 * Description the class  ActivePatternValidator.java 
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 */
public class ActivePatternValidator implements ConstraintValidator<ActivePattern, String> {

    @Override
    public void initialize(ActivePattern constraintAnnotation) {

    }

    @Override
    public boolean isValid(String active, ConstraintValidatorContext context) {
        return active.equals("S") || active.equals("N");
    }

}