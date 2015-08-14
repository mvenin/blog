package env;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.cloudfoundry.env.PrmFileConstraintValidator;
import org.cloudfoundry.env.SignupForm;

public class ValidationTest {

	public static void main(String[] args) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		SignupForm signupForm = new SignupForm();

		Set<ConstraintViolation<SignupForm>> constraintViolations = validator.validate(signupForm,
				javax.validation.groups.Default.class, SignupForm.Step1.class);

		for (ConstraintViolation<SignupForm> cv : constraintViolations) {
			System.out.println(cv.getMessage() + "\t" + cv);
		}

	}

}
