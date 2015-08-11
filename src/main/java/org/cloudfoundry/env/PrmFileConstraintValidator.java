package org.cloudfoundry.env;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.MessageInterpolator;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;

public class PrmFileConstraintValidator implements ConstraintValidator<PrmFileConstraint, SignupForm> {
	
	public interface Step1{}
	public interface Step2{}
	
	private MessageInterpolator interpolatorUnderTest;

	@Override
	public void initialize(PrmFileConstraint constraintAnnotation) {
		// TODO Auto-generated method stub
		System.out.println(constraintAnnotation);
		
		
		interpolatorUnderTest = new ResourceBundleMessageInterpolator();
	}

	@Override
	public boolean isValid(SignupForm form, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		System.out.println(context);
		context.buildConstraintViolationWithTemplate("some mesage").addPropertyNode( "street" )
        .addConstraintViolation();

		return true;
	}

}
