package org.cloudfoundry.env;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SprValidator sprValidator;
	
	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	@RequestMapping(value = "signup", method = RequestMethod.POST, consumes=APPLICATION_JSON_VALUE)
	@ResponseBody
	public String signup(  @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
//		Errors e2 = new BeanPropertyBindingResult(signupForm, "signupForm");
		//this.sprValidator.validate(signupForm, e2);
		
		Set<ConstraintViolation<SignupForm>> constraintViolations=null;
		int i = 1;
		if(i == 1){
			constraintViolations  = validator.validate(signupForm, javax.validation.groups.Default.class, PrmFileConstraintValidator.Step1.class);
		} else {
				constraintViolations  = validator.validate(signupForm, javax.validation.groups.Default.class, PrmFileConstraintValidator.Step2.class);
		}
		System.out.println(constraintViolations);
		return  constraintViolations.toString().replaceAll("ConstraintViolationImpl", "\nConstraintViolationImpl");
		
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	@RequestMapping("/env")
	public void env(HttpServletResponse response) throws IOException {
	    response.setContentType("text/plain");
	    PrintWriter out = response.getWriter();
	    out.println("System Environment:");
	    for (Map.Entry<String, String> envvar : System.getenv().entrySet()) {
	        out.println(envvar.getKey() + ": " + envvar.getValue());
	    }
	}
}
