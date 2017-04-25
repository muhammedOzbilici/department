package com.mhmt.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String>{
	
	private Pattern pattern;
	private Matcher matcher;
	
	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$" ;

	@Override
	public void initialize(ValidEmail obj) {
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext arg1) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		
		return matcher.matches();
	}

}
