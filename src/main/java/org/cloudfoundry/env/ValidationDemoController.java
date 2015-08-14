package org.cloudfoundry.env;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Path.Node;
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
import org.validationdemo.ValidationUtil;

@Controller
public class ValidationDemoController {

	@Autowired ApplicationContext appCtx;
	
	@Autowired
	private Validator validator;

	@RequestMapping(value = "vc", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
	@ResponseBody
	public String validate(@ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
		
//		signupForm.setEmail("email");
		signupForm.setFile(new HrFile());
		
		Set<ConstraintViolation<SignupForm>> cvs = Collections.emptySet();
		
		if( signupForm.getType() == 0){
		  cvs = validator.validate(signupForm,
				javax.validation.groups.Default.class,
				SignupForm.S1.class);
		} else {
			 cvs = validator.validate(signupForm,
						javax.validation.groups.Default.class,
						SignupForm.S1g1.class);
		}
		
		int i=0;
		for (ConstraintViolation<SignupForm> cv : cvs) {
			String fname = ValidationUtil.getPath(cv);
			System.out.println(++i + " "+ fname + "\t"+ cv.getMessage() + "\t" +    cv);
		}
		
		return cvs.toString();
	}

}