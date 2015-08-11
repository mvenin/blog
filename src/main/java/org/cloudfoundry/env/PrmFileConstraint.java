package org.cloudfoundry.env;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@NotNull
//@Size(min = 2, max = 14)
@Target({ TYPE, METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PrmFileConstraintValidator.class)
@Documented
@ReportAsSingleViolation
public @interface PrmFileConstraint {

	String message() default "{com.mycompany.constraints.validlicenseplate}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}