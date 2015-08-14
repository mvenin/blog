package org.cloudfoundry.env;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@PrmFileConstraint
public class SignupForm extends BaseForm {
	public interface S1 {
	}

	public interface S1g1 {
	}

	public interface S2 {
	}

	public interface S2g1 {
	}

	private int type;

	@NotNull
	@Email
	private String email;

	@NotBlank(message = "{car.notBlankX}")
	private String password;

	@NotBlank(message = "{car.notBlankX}", groups = { S1.class, S1g1.class })
	private String fieldStep1a;

	@NotBlank(message = "{env.notBlankX}", groups = { S1g1.class })
	private String fieldStep1b;

	@NotBlank(message = "{car.notBlankX}", groups = { S2.class, S2g1.class })
	private String fieldStep2a;

	@NotBlank(message = "{car.notBlankX}", groups = S2g1.class)
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
