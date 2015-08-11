package org.cloudfoundry.env;

import org.hibernate.validator.constraints.*;

@PrmFileConstraint()
public class SignupForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
	private static final String EMAIL_MESSAGE = "{email.message}";

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	@Email(message = SignupForm.EMAIL_MESSAGE)
	private String email;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String password;
    
    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE, groups=PrmFileConstraintValidator.Step1.class)
    private String fieldStep1a;
    
    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE, groups=PrmFileConstraintValidator.Step1.class)
    private String fieldStep1b;
    
    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE, groups=PrmFileConstraintValidator.Step2.class)
    private String fieldStep2a;
    
    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE, groups=PrmFileConstraintValidator.Step2.class)
    private String fieldStep2b;

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFieldStep1a() {
		return fieldStep1a;
	}

	public void setFieldStep1a(String fieldStep1a) {
		this.fieldStep1a = fieldStep1a;
	}

	public String getFieldStep1b() {
		return fieldStep1b;
	}

	public void setFieldStep1b(String fieldStep1b) {
		this.fieldStep1b = fieldStep1b;
	}

	public String getFieldStep2a() {
		return fieldStep2a;
	}

	public void setFieldStep2a(String fieldStep2a) {
		this.fieldStep2a = fieldStep2a;
	}

	public String getFieldStep2b() {
		return fieldStep2b;
	}

	public void setFieldStep2b(String fieldStep2b) {
		this.fieldStep2b = fieldStep2b;
	}

	
}
