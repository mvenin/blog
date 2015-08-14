package org.cloudfoundry.env;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

public class PrmFileConstraintValidator implements ConstraintValidator<PrmFileConstraint, Object> {

	private Class<?>[] groups = new Class<?>[0];
	private Class<? extends Payload>[] payload;

	public PrmFileConstraintValidator() {
		System.out.println(this.hashCode());
	}

	public void initialize(PrmFileConstraint ca) {
		groups = ca.groups();
		payload = ca.payload();
	}

	public boolean isValid(Object val, ConstraintValidatorContext context) {
		SignupForm form;
		if (val instanceof SignupForm) {
			form = (SignupForm) val;

			context.buildConstraintViolationWithTemplate("{class.level.validation}").addConstraintViolation();
			
			if (isStep1()) {
				if (form.getFieldStep1a() == null) {
					context.buildConstraintViolationWithTemplate("{org.cloudfoundry.env.notBlankX}").addNode("fieldStep1a")
							.addConstraintViolation();
				}
			} else if (isStep2()) {
				if (form.getFieldStep2b() == null) {
					context.buildConstraintViolationWithTemplate("{org.cloudfoundry.env.notBlankX}").addNode("fieldStep2b")
							.addConstraintViolation();
				}
			}
		}
		return false;
	}

	private boolean isStep2() {
		if (this.groups == null) {
			return false;
		} else {
			for (Class<?> gr : groups) {
				if (gr.isAssignableFrom(SignupForm.S2.class)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isStep1() {
		for (Class<?> gr : groups) {
			if (gr.isAssignableFrom(SignupForm.S1.class)) {
				return true;
			}
		}
		return false;
	}

}
