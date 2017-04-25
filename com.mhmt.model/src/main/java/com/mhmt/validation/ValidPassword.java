package com.mhmt.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Target({
	ElementType.TYPE , ElementType.ANNOTATION_TYPE , ElementType.FIELD
})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordConstrainValidator.class)
@Documented
public @interface ValidPassword {

}
