package com.mhmt.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConstrainValidator implements ConstraintValidator<ValidPassword, String>{

	@Override
	public void initialize(ValidPassword arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
