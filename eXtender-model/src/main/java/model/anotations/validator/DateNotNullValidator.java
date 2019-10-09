/**
 * DateNotNullValidator.java
 * Created on 9 de out de 2019
 * 
 *
 */

package model.anotations.validator;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import model.anotations.DateNotNull;
/**
 * 
 * Description the class  DateNotNullValidator.java 
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 */
public class DateNotNullValidator implements ConstraintValidator<DateNotNull, Date> {

    @Override
    public void initialize(DateNotNull constraintAnnotation) {

    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {
        if (date == null) {
            return true;
        }             
        return false;
    }

}

