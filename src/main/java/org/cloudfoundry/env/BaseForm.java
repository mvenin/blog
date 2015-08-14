package org.cloudfoundry.env;

import javax.validation.Valid;

import org.cloudfoundry.env.SignupForm.S1;
import org.cloudfoundry.env.SignupForm.S1g1;

public class BaseForm {

    @PrmFileConstraint(groups={S1g1.class})
    private String fieldStep3;
    
    @Valid
	private HrFile file;

	public HrFile getFile() {
		return file;
	}

	public void setFile(HrFile file) {
		this.file = file;
	}
	
}
