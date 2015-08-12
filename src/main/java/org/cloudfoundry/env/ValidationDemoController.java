package org.cloudfoundry.env;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ValidationDemoController {

	@Autowired ApplicationContext appCtx;
	
	@Autowired
	private Validator validator;

	@RequestMapping(value = "vc", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
	@ResponseBody
	public String signup(@ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
		
		Set<ConstraintViolation<SignupForm>> cvs = validator.validate(signupForm,
//				javax.validation.groups.Default.class,
				SignupForm.Step1.class);

		int i=0;
		for (ConstraintViolation<SignupForm> cv : cvs) {
			System.out.println(++i + " "+ cv.getMessage() + "\t" + cv);
		}
		
		return cvs.toString();
	}

}