package org.cloudfoundry.env;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidationPercentageImpl implements ConstraintValidator<ValidationPercentage, Object> {

	@Override
	public void initialize(ValidationPercentage constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	
}