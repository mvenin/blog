package org.cloudfoundry.env;

import org.hibernate.validator.constraints.*;

@PrmFileConstraint(groups={SignupForm.Step1.class, SignupForm.Step2.class})
public class SignupForm {
	public final class Step1 {}

	public interface Step2 {}
	
    @NotBlank(message = "{car.notBlankX}")
	private String email;

    @NotBlank(message = "{car.notBlankX}")
	private String password;
    
    @PrmFileConstraint()
    @NotBlank(message = "{car.notBlankX}", groups=Step1.class)
    private String fieldStep1a;
    
    @PrmFileConstraint()
    @NotBlank(message = "{org.cloudfoundry.env.notBlankX}", groups=Step1.class)
    private String fieldStep1b;
    
    @NotBlank(message = "{car.notBlankX}", groups=Step2.class)
    private String fieldStep2a;
    
    @NotBlank(message = "{car.notBlankX}", groups=Step2.class)
    private String fieldStep2b;
    
    @PrmFileConstraint(groups={Step1.class})
    private String fieldStep3;
    
    
    
    

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
