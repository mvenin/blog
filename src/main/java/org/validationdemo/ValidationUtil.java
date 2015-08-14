package org.validationdemo;

import javax.validation.ConstraintViolation;

import org.hibernate.validator.internal.engine.PathImpl;

public final class ValidationUtil {

	public static <T> String getPath(ConstraintViolation<T> cv){
		return ((PathImpl)cv.getPropertyPath()).asString();
	}
}
