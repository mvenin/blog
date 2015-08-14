package org.cloudfoundry.env;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Collections;
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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
//@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
//	MessageSource messageSource;
//	@Autowired @Qualifier("validator2")
	private Validator sprValidator;
	
	@Autowired ApplicationContext appCtx;
	
	public void initHomeController() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:sisysper2_web_pages");
		messageSource.setDefaultEncoding("UTF-8");
		
		LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
		factory.setValidationMessageSource(messageSource);
		sprValidator = factory.getValidator();
	}

	@RequestMapping(value = "signup", method = RequestMethod.POST, consumes=APPLICATION_JSON_VALUE)
	@ResponseBody
	public String signup(   @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
		Errors e2 = new BeanPropertyBindingResult(signupForm, "signupForm");
		Set<ConstraintViolation<SignupForm>> constraintViolations= this.sprValidator.validate(signupForm, javax.validation.groups.Default.class, SignupForm.S1.class); //Collections.emptySet();// 
		System.out.println(e2);
		
//		Set<ConstraintViolation<SignupForm>> constraintViolations=null;
		int i = 10;
		if(i == 1){
			constraintViolations  = validator.validate(signupForm, javax.validation.groups.Default.class, SignupForm.S1.class);
		} else {
//			constraintViolations  = validator.validate(signupForm, javax.validation.groups.Default.class, PrmFileConstraintValidator.Step2.class);
		}
		
		for (ConstraintViolation<SignupForm> cv : constraintViolations) {
			System.out.println(cv.getMessage()+"\t"+cv);
		}
		return   constraintViolations.toString();
//		return errors.toString();
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
