package com.mhmt.validation;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({
        ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD
})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordConstrainValidator.class)
@Documented
public @interface ValidPassword {

}
