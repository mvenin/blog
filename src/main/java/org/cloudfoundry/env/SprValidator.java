package org.cloudfoundry.env;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//@Component
public class SprValidator //implements Validator 
{

	public boolean supports(Class<?> clazz) {
		// return EmployeeVO.class.isAssignableFrom(clazz);
		return true;
	}

	public void validate(Object target, Errors errors) {
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstName", "First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "Password is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "org.cloudfoundry.env.notBlankX", "Email is required.");
	}

}
